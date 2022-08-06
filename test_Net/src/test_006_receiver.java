import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class test_006_receiver {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] arr = new byte[100];
        DatagramPacket packet = new DatagramPacket(arr,0,arr.length);

        socket.receive(packet);

        // 获取里面的数据
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
