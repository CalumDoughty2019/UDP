import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class QODTClient {

    private DatagramSocket qodtSocket;
    private InetAddress serverAddress;
    private int port;
    private Scanner scanner;

    private QODTClient(String destinationAddress, int port) throws IOException {
        this.serverAddress = InetAddress.getByName(destinationAddress);
        this.port = port;
        qodtSocket = new DatagramSocket();
        scanner = new Scanner(System.in);
    }

//    public static void main(String[] args) throws NumberFormatException, IOException{
//        QODTClient sender = new QODTClient("192.168.0.105", 54432); //InetAddress.getLocalHost().toString() //Got IP from running this
//        System.out.println("-- Running client at " + InetAddress.getLocalHost() + " --");
//        sender.start();
//    }

    private int start() throws IOException{
        String input;
        while(true){
            System.out.println("Please enter a message to send: ");
            input = scanner.nextLine();

            DatagramPacket packet = new DatagramPacket(input.getBytes(), input.getBytes().length, serverAddress, port);

            this.qodtSocket.send(packet);
        }
    }

//    public static void main(String[] args) throws NumberFormatException, IOException{
//        QODTClient sender = new QODTClient("djxmmx.net", 17); //InetAddress.getLocalHost().toString() //Got IP from running this
//        System.out.println("-- Running client at " + InetAddress.getLocalHost() + " --");
//        DatagramPacket packet = new DatagramPacket("", );
//        qodtSocket.send(packet);
//    }
}
