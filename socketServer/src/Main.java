import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MySocketServer mySocketServer = new MySocketServer();
        mySocketServer.start(4652);

    }

}
