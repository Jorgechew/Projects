import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {


        // STEP1: Get your host and port

        int portNumber = 8080;

        // STEP2: Create send and receive buffers
        System.out.println("Message: ");
        Scanner reader = new Scanner(System.in);
        String message = reader.nextLine();

        byte[] sendBuffer = message.getBytes();
        byte[] recvBuffer = new byte[1024];


        // STEP3: Open a UDP (datagram) socket
        DatagramSocket socket = new DatagramSocket(33333);

        /* STEP4.1: Create and receive UDP datagram packet from the socket
        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket); // blocks while packet not received */

        // STEP4.2: Create and send UDP datagram packet from the socket
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                sendBuffer.length, InetAddress.getByName("localhost"), 8080);
        socket.send(sendPacket);

        // STEP5: Close the socket
        socket.close();

    }

    private static String getHost() {

        Scanner reader = new Scanner(System.in);
        System.out.print("Hostname? ");
        return reader.nextLine();

    }


}