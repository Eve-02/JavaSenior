import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class test_03_client2 {

    public static void main(String[] args){

        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),3456);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream("01.jpg");

            byte[] arr = new byte[1024];
            int len;
            while((len = fileInputStream.read(arr)) != -1){
                outputStream.write(arr,0,len);
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
