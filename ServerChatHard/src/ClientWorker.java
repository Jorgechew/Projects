import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;


public class ClientWorker implements Runnable {

    private PrintWriter print;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

   private Server server;

    public ClientWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.out = out;
        this.in = in;

    }

    public void listen() throws IOException {

        //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while (true) {


            String text = in.readLine();
            System.out.println(text);



            if (text.equals("quit")) {
                clientSocket.close();
                clientSocket.close();
                return;
            }
        }
    }






    //public void listen(int )

    @Override
    public void run() {

        while (true) {
            try {
                listen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private void brodCast(String text) throws IOException {
       for (ClientWorker worker : server.getList()){

            worker.send(text);
        }


    }

    private  void send(String text) throws IOException{
        print = new PrintWriter(clientSocket.getOutputStream(),true);
        print.println(text);
        print.flush();
    }
}
