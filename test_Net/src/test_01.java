import java.net.InetAddress;
import java.net.UnknownHostException;

public class test_01 {

    public static void main(String[] args) {
        try {
            // ip地址
            InetAddress inet1 = InetAddress.getByName("192.168.25.24");
            // 域名
            InetAddress inet2 = InetAddress.getByName("www.baidu.com"); // 会解析ip地址
            // 本地回路地址: 127.0.0.1 (Localhost)
            InetAddress inet3 = InetAddress.getByName("Localhost"); // 127.0.0.1
            // 直接获取本机地址
            InetAddress inet4 = InetAddress.getLocalHost();

            System.out.println(inet1);
            System.out.println(inet2);
            System.out.println(inet3);
            System.out.println(inet4);

            System.out.println(inet2.getHostName()); // 域名
            System.out.println(inet2.getHostAddress()); // ip地址


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
