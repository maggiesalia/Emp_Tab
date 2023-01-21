import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyClientServer {

    private Socket clientSocket;

    private PrintWriter out;
    private BufferedReader in;

    public void connect(int port, String ip) throws IOException {
        clientSocket = new Socket(ip, port);

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public String sendMessage(String message) throws IOException {

        out.println(message);
        String response = in.readLine();

        return response;

    }

    public void close() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
    }

}
