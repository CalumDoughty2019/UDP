import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPClient {

    private DatagramSocket udpSocket;
    private InetAddress serverAddress;
    private int port;
    private Scanner scanner;

    private UDPClient(String destinationAddress, int port) throws IOException{
        this.serverAddress = InetAddress.getByName(destinationAddress);
        this.port = port;
        udpSocket = new DatagramSocket();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws NumberFormatException, IOException{
        UDPClient sender = new UDPClient("192.168.0.105", 54432); //InetAddress.getLocalHost().toString() //Got IP from running this
        System.out.println("-- Running client at " + InetAddress.getLocalHost() + " --");
        sender.start();
    }

    private int start() throws IOException{
        String input;
        while(true){
            System.out.println("Please enter a message to send: ");
            input = scanner.nextLine();

            DatagramPacket packet = new DatagramPacket(input.getBytes(), input.getBytes().length, serverAddress, port);

            this.udpSocket.send(packet);
        }
    }
}
