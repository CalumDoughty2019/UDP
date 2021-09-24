import java.io.IOException;
import java.net.*;

public class UDPServer {

    private DatagramSocket udpSocket;
    private int port;

    public UDPServer(int port) throws SocketException, IOException{
        this.port = port;
        this.udpSocket = new DatagramSocket(this.port);
    }

    private void listen() throws Exception{
        System.out.println("-- Running Server at " + InetAddress.getLocalHost() + " --");
        String message;

        while(true){
            byte[] buffer = new byte[256]; //hold the information
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length); //wrap info in a datagram packet

            udpSocket.receive(packet); //which we can receive through our UDP socket

            message = new String(packet.getData()).trim(); //getting data out of that socket and trimming it down to only what is neccessary

            System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + message);
        }
    }

    public static void main(String[] args) throws Exception{
        UDPServer server = new UDPServer(54432);
        server.listen(); //listen down this port
    }
}
