package org.academiadecodigo.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Single-threaded simple web server implementation
 */
public class WebServer  {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());
    // Registra a atividade do servidor

    public static final String DOCUMENT_ROOT = "www/";
    //Representa o diretório raiz para servir o contéudo web
    public static final int DEFAULT_PORT = 9050;
    //Representa porta padrão do servidor

    private ServerSocket bindSocket = null;

    public static void main(String[] args) {

        try {

            int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

            WebServer webServer = new WebServer();
            webServer.listen(port);

        } catch (NumberFormatException e) {

            System.err.println("Usage: WebServer [PORT]");
            System.exit(1);

        }
    }

    /* O método listen cria um ServerSocket e o vincula à porta especificada.
    Se for bem-sucedido, ele começa a atender as conexões de clientes chamando o método serve.*/

    private void listen(int port) {

        try {

            bindSocket = new ServerSocket(port);
            logger.log(Level.INFO, "server bind to " + getAddress(bindSocket));

            serve(bindSocket);

        } catch (IOException e) {

            logger.log(Level.SEVERE, "could not bind to port " + port);
            logger.log(Level.SEVERE, e.getMessage());
            System.exit(1);

        }
    }


    /*O método serve aceita continuamente conexões de clientes usando o método accept do ServerSocket.
    Para cada conexão aceita, ele cria uma nova thread e despacha a conexão do cliente para ela, chamando o método dispatch.*/

    private void serve(ServerSocket bindSocket) {

        while (true) {

            try {

                Socket clientSocket = bindSocket.accept();
                logger.log(Level.INFO, "new connection from " + getAddress(clientSocket));

                dispatch(clientSocket);


            } catch (IOException e) {

                logger.log(Level.SEVERE, e.getMessage());

            }
        }
    }

    /*O método dispatch cria um novo objeto Task (implementado como uma classe interna) e o executa em uma thread separada.
     Isso permite o tratamento simultâneo de várias conexões de clientes.
     */

    private void dispatch(Socket clientSocket) {

        Thread thread = new Thread(new Task(clientSocket));
        thread.start();

    }

   /* A classe Task implementa a interface Runnable e representa uma tarefa
    que lida com uma única conexão de cliente.
    */

    public class Task implements Runnable{

        private Socket clientSocket;

        public Task(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        /* O método run da classe Task é o ponto de entrada para o tratamento de uma conexão de cliente.
        Ele lê os cabeçalhos da solicitação do cliente, extrai o verbo HTTP, o recurso e outras informações dos cabeçalhos.
         */

        @Override
        public void run() {
            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String requestHeaders = fetchRequestHeaders(in);
                if (requestHeaders.isEmpty()) {
                    close(clientSocket);
                    return;
                }

                String request = requestHeaders.split("\n")[0]; // request is first line of header
                String httpVerb = request.split(" ")[0]; // verb is the first word of request
                String resource = request.split(" ").length > 1 ? request.split(" ")[1] : null; // second word of request

                logger.log(Level.INFO, "Request received: " + request);
                logger.log(Level.FINE, "Headers : \n" + requestHeaders);



                /* Com base no verbo HTTP e no recurso, ele determina como lidar com a solicitação.
                   Nesta implementação, apenas as solicitações GET são suportadas.
                */

                if (!httpVerb.equals("GET")) {
                    logger.log(Level.WARNING, "request not supported from " + getAddress(clientSocket));
                    reply(out, HttpHelper.notAllowed());
                    close(clientSocket);
                    return;

                }

                if (resource == null) {
                    logger.log(Level.WARNING, "resource not specified from " + getAddress(clientSocket));
                    reply(out, HttpHelper.badRequest());
                    close(clientSocket);
                    return;
                }

                String filePath = getPathForResource(resource);
                if (!HttpMedia.isSupported(filePath)) {
                    logger.log(Level.WARNING, "request for content type not supported from " + getAddress(clientSocket));
                    reply(out, HttpHelper.unsupportedMedia());
                    close(clientSocket);
                    return;
                }

                //Se o recurso solicitado não for encontrado ou não for suportado, respostas HTTP apropriadas são enviadas de volta ao cliente.
                File file = new File(filePath);
                if (file.exists() && !file.isDirectory()) {

                    reply(out, HttpHelper.ok());

                } else {

                    logger.log(Level.WARNING, file.getPath() + " not found");
                    reply(out, HttpHelper.notFound());
                    filePath = WebServer.DOCUMENT_ROOT + "404.html";
                    file = new File(filePath);

                }

                reply(out, HttpHelper.contentType(filePath));
                reply(out, HttpHelper.contentLength(file.length()));

                streamFile(out, file);
                close(clientSocket);
                /* Se o recurso for encontrado, uma resposta HTTP 200 OK é enviada juntamente com os cabeçalhos de tipo de conteúdo e comprimento.
       Em seguida, o conteúdo do arquivo é transmitido ao cliente.
        */

                /* teste para ver se funciona
                while(true){
                    System.out.println("hello");
                }*/

            } catch (SocketException ex) {

                logger.log(Level.INFO, "client disconnected " + getAddress(clientSocket));

            } catch (IOException ex) {

                logger.log(Level.WARNING, ex.getMessage());
                close(clientSocket);
            }
        }
    }

    /*O método fetchRequestHeaders lê os cabeçalhos da solicitação do cliente até
     encontrar uma linha vazia e retorna os cabeçalhos como uma string.
     */
    private String fetchRequestHeaders(BufferedReader in) throws IOException {

        String line = null;
        StringBuilder builder = new StringBuilder();

        // read the full http request
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            builder.append(line + "\n");
        }

        return builder.toString();

    }


    /* O método getPathForResource recebe um caminho de recurso e retorna o caminho do arquivo correspondente, anexando-o ao DOCUMENT_ROOT.
    Se o caminho do recurso não tiver uma extensão de arquivo, ele assume que o recurso é um diretório e anexa "/index.html" ao caminho.
     */

    private String getPathForResource(String resource) {

        String filePath = resource;

        Pattern pattern = Pattern.compile("(\\.[^.]+)$"); // regex for file extension
        Matcher matcher = pattern.matcher(filePath);

        if (!matcher.find()) {
            filePath += "/index.html";
        }

        filePath = WebServer.DOCUMENT_ROOT + filePath;

        return filePath;
    }

    //O método reply envia uma string de resposta ao cliente escrevendo-a no DataOutputStream.
    private void reply(DataOutputStream out, String response) throws IOException {
        out.writeBytes(response);
    }


   // O método streamFile lê o conteúdo de um arquivo e o transmite ao cliente escrevendo-o no DataOutputStream em partes.
    private void streamFile(DataOutputStream out, File file) throws IOException {

        byte[] buffer = new byte[1024];
        FileInputStream in = new FileInputStream(file);

        int numBytes;
        while ((numBytes = in.read(buffer)) != -1) {
            out.write(buffer, 0, numBytes);
        }

        in.close();

    }


    //O método close fecha o socket do cliente e registra uma mensagem.
    private void close(Socket clientSocket) {

        try {

            logger.log(Level.INFO, "closing client socket for " + getAddress(clientSocket));
            clientSocket.close();

        } catch (IOException e) {

            logger.log(Level.INFO, e.getMessage());
        }

    }

    //Os métodos getAddress retornam uma representação em string do endereço IP e número da porta do servidor ou socket do cliente.
    private String getAddress(ServerSocket socket) {

        if (socket == null) {
            return null;
        }

        return socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort();
    }

    private String getAddress(Socket socket) {
        return socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort();
    }

}
