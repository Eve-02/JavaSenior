import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class test_05_server4 {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3333);
        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        String str = null;

        byte[] arr = new byte[1024];
        int len;
        while((len = inputStream.read(arr)) != -1){
            str = new String(arr,0,len);
        }
        String s = str.toUpperCase();
        outputStream.write(s.getBytes());

        outputStream.close();
        inputStream.close();
        ss.close();
    }
}
