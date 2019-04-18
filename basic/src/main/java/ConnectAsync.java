import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by mars on 2017/2/10.
 */
public class ConnectAsync {
    public static void main(String... args) {
        ByteBuffer receive = ByteBuffer.allocate(50);
        InetSocketAddress address = new InetSocketAddress("localhost", 1234);
        try {
            SocketChannel sc = SocketChannel.open();
//            sc.configureBlocking(false);
            System.out.println("initiating connection");
            sc.connect(address);
            while (!sc.finishConnect()) {

            }
            sc.read(receive);
            System.out.println("connection established");
            receive.rewind();
            byte[] data = receive.array();
            String msg = new String(data).trim();
            System.out.println("服务端收到信息：" + msg);
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
