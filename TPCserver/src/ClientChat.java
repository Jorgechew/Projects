import javax.crypto.CipherInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) throws IOException {

        String hostName = "localhost";
        int portNumber = 8090;

        // STEP2: Open a client socket, blocking while connecting to the server

        Socket clientSocket = new Socket(hostName, portNumber);

        System.out.println("SUCCESS!!!!!!!!!!!");

        // STEP3: Setup input stream
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Message:");
            String message = scanner.nextLine();
            out.println(message);
            if (message.equals("quit")) {
                clientSocket.close();
                return;
            }
        }

    }


}

