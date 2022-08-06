import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class test_04_server3 {

    public static void main(String[] args) {
        // 服务端
        ServerSocket ss = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            ss = new ServerSocket(3456);
            // 接受客户端socket
            accept = ss.accept();
            inputStream = accept.getInputStream();

            // 读取并输出
            outputStream = new FileOutputStream("002.jpg");
            byte[] arr = new byte[1024];
            int len;
            while((len = inputStream.read(arr)) != -1){
                outputStream.write(arr,0,len);
            }

            // 发送给客户端
            OutputStream outputStream1 = accept.getOutputStream();
            outputStream1.write("你好！图片已经保存到本地!".getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(accept != null){
                try {
                    accept.close();
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
