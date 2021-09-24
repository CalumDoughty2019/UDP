import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class QOTDServer {
    private DatagramSocket qodtSocket;
    private int port;

    public QOTDServer(int port) throws SocketException, IOException {
        this.port = port;
        this.qodtSocket = new DatagramSocket(this.port);
    }

    private void listen() throws Exception{
        System.out.println("-- Running Server at " + InetAddress.getLocalHost() + " --");
        String message;

        while(true){
            byte[] buffer = new byte[256]; //hold the information
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length); //wrap info in a datagram packet

            qodtSocket.receive(packet); //which we can receive through our UDP socket

            message = new String(packet.getData()).trim(); //getting data out of that socket and trimming it down to only what is neccessary

            System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + message);
        }
    }

    public static void main(String[] args) throws Exception{
        QOTDServer server = new QOTDServer(54432);
        server.listen(); //listen down this port
    }

//    public static void main(String[] args) throws Exception{
//        QOTDServer server = new QOTDServer(17);
//        server.listen(); //listen down this port
//    }
}
