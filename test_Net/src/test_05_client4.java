import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class test_05_client4 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),3333);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        String str;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要转换大写的英文!");
        str = in.nextLine();
        outputStream.write(str.getBytes());
        socket.shutdownOutput();

        byte[] arr = new byte[1024];
        int len;
        while((len = inputStream.read(arr)) != -1){
            str = new String(arr,0,len);
        }
        System.out.println("转换完成!");
        System.out.println(str);


        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
