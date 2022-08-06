import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class test_04_client3 {

    public static void main(String[] args){

        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),3456);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream("01.jpg");

            // 发送给服务器
            byte[] arr = new byte[1024];
            int len;
            while((len = fileInputStream.read(arr)) != -1){
                outputStream.write(arr,0,len);
            }

            // 停止数据的发送
            socket.shutdownOutput();

            // 得到服务器的反馈
            InputStream inputStream = socket.getInputStream();
            byte[] arr1 = new byte[1024];
            int len1;
            while((len = inputStream.read(arr1)) != -1){
                System.out.println(new String(arr1,0,len));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
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
        }


    }
}
