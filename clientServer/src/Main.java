import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MyClientServer myClientServer = new MyClientServer();
        myClientServer.connect(4652, "127.0.0.1");
        String response = myClientServer.sendMessage("hello server");
        System.out.println(response);
    }
}
