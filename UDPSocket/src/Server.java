import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {


        // STEP1: Get your host and port

        int portNumber = 8080;

        // STEP2: Create send and receive buffers

        //System.out.println("Message: ");
        //Scanner reader = new Scanner(System.in);
        //String message = reader.nextLine();

        //byte[] send = send.getBytes();
        byte[] recv = new byte[1024];

        // STEP3: Open a UDP (datagram) socket
        DatagramSocket socket = new DatagramSocket(8080);

        // STEP4.1: Create and receive UDP datagram packet from the socket
        DatagramPacket receivePacket = new DatagramPacket(recv, recv.length);
        socket.receive(receivePacket);

       

        String messageRec = new String(recv, 0, receivePacket.getLength());
        System.out.println(messageRec);
        System.out.println(messageRec.toUpperCase());


        // blocks while packet not received

        // STEP4.2: Create and send UDP datagram packet from the socket

        //DatagramPacket sendPacket = new DatagramPacket(send,
          //      send.length, InetAddress.getByName("localhost"), 8082);
        //socket.send(sendPacket);

        // STEP5: Close the socket
        socket.close();

        /*private static String getHost() {

            Scanner reader = new Scanner(System.in);
            System.out.print("Hostname? ");
            return reader.nextLine();

        }*/


    }

}
