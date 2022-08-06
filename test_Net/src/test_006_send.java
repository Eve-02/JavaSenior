import java.io.IOException;
import java.net.*;

public class test_006_send {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是udp发送的信息!";
        byte[] date = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();

        DatagramPacket packet = new DatagramPacket(date,0,date.length,inet,9090);
        socket.send(packet);

        socket.close();
    }
}
