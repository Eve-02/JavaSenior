import java.io.*;

public class test_11 {

    public static void main(String[] args){

        InputStreamReader isr = null;
        try {
            FileInputStream f = new FileInputStream("tc.text");
            isr = new InputStreamReader(f,"UTF-8"); // 参数为文件保存时的字符集

            char[] arr = new char[20];
            int len;
            while((len = isr.read(arr)) != -1){
                String str = new String(arr,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
