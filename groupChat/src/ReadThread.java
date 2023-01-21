import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReadThread implements Runnable{

    private MulticastSocket socket;

    private InetAddress socketAddress;
    private  int port;
    private final static int MAX_LENGTH = 1000;


    public ReadThread(MulticastSocket socket, InetAddress socketAddress, int port) {
        this.socket = socket;
        this.socketAddress = socketAddress;
        this.port = port;
    }

    @Override
    public void run() {
        while (GroupChat.finished){
            byte[] buffer = new byte[MAX_LENGTH];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, socketAddress, port);
            try {
                socket.receive(datagramPacket);
                String received = new String(buffer,0, datagramPacket.getLength(), "UTF-8");
                System.out.println(received);
            } catch (IOException e) {
                System.out.println("socket is closed");
            }
        }
    }
}
