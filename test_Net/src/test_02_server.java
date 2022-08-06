import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class test_02_server {

    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        try {
            ss = new ServerSocket(8899);

            socket = ss.accept();

            InputStream inputStream = socket.getInputStream();

            // 可能会有乱码
//        byte[] arr = new byte[20];
//        int len;
//        while((len = inputStream.read(arr)) != -1){
//            String str = new String(arr,0,len);
//            System.out.println(str);
//        }

            inputStreamReader = new InputStreamReader(inputStream);
            char[] arr = new char[20];
            int len;
            while((len = inputStreamReader.read(arr)) != -1){
                String str = new String(arr,0,len);
                System.out.println(str);
            }
            System.out.println("收到了来自于："+socket.getInetAddress().getHostName()+"的数据");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
