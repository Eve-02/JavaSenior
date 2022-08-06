import java.io.*;

public class test_12 {

    public static void main(String[] args){
        InputStreamReader in1 = null;
        OutputStreamWriter ou1 = null;
        try {
            FileInputStream f1 = new FileInputStream("tc.text");
            FileOutputStream f2 = new FileOutputStream("tc01.text");

            // 1.InputStreamReader[字节-->字符,解码]:
            // 使用字节输入流读取字节， 根据转换流的编码集进行解码成字符，再使用输入转换流把解码后的字符读到内存中
            // 2.OutputStreamWriter[字符-->字节,编码]:
            // 使用输出转换流读取字符，根据转换流的编码集进行编码成字符，再使用字节输出流把编码后的字节写出到文件中
            in1 = new InputStreamReader(f1,"utf-8");
            ou1 = new OutputStreamWriter(f2, "gbk");

            char[] arr = new char[20];
            int len;
            while((len = in1.read(arr)) != -1){
                ou1.write(arr,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(in1 != null){
                    in1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(ou1 != null){
                    ou1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
