import sun.lwawt.macosx.CPlatformEmbeddedFrame;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private Socket clientSocket;
    private static List<ClientWorker> list = Collections.synchronizedList(new LinkedList<>());
    private ServerSocket serverSocket;
    private ExecutorService pool = Executors.newCachedThreadPool();

    public Server(int port) {

        try {

            // bind the socket to specified port
            System.out.println("Binding to port " + port);
            int count = 0;
            serverSocket = new ServerSocket(8080);

            System.out.println("Server started: " + serverSocket);

            // block waiting for a client to connect


            while (true) {

                System.out.println("Waiting for a client connection");
                clientSocket = serverSocket.accept();
                System.out.println(count++);
                ClientWorker clientWorker = new ClientWorker(clientSocket);
                pool.submit(clientWorker);
                list.add(clientWorker);

                // handle client connection
                System.out.println("Client accepted: " + clientSocket);

            }


        } catch (IOException ioe) {

            System.out.println(ioe.getMessage());

        } finally {

            close();

        }

    }

    public static List<ClientWorker> getList() {
        return list;
    }

    /**
     * ChatServer entry point
     *
     * @param args ChatServer port number
     */
    public static void main(String args[]) {

        // exit application if no port number is specified
        if (args.length == 0) {
            System.out.println("Usage: java ChatServer [port]");
            System.exit(1);
        }

        try {
            // try to create an instance of the ChatServer at port specified at args[0]
            new Server(Integer.parseInt(args[0]));

        } catch (NumberFormatException ex) {
            // write an error message if an invalid port was specified by the user
            System.out.println("Invalid port number " + args[0]);
        }

    }

    /**
     * Closes the client socket and the buffered input reader
     */
    public void close() {

        try {

            if (clientSocket != null) {
                System.out.println("Closing client connection");
                clientSocket.close();
            }

            if (serverSocket != null) {
                System.out.println("Closing server socket");
                serverSocket.close();
            }


        } catch (IOException ex) {

            System.out.println("Error closing connection: " + ex.getMessage());

        }

    }
}




