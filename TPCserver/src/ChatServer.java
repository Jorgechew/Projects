import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    public static void main(String[] args) throws IOException {

        int portNumber = 8090;

        // STEP2: Bind to local port and block while waiting for client connections
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("WAITING!!!");
        Socket clientSocket = serverSocket.accept();
        System.out.println("REQUEST ACCEPT!!!");

        // STEP3: Setup output streams

        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String text = in.readLine();
            System.out.println(text);
            if (text.equals("quit")) {
                serverSocket.close();
                return;
            }
        }

    }
}
