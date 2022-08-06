import java.io.*;

public class test_07 {

    public static void main(String[] args)  {
        // 1.创建读入的File对象和写出的File对象
        File file1 = new File("01.jpg");
        File file2 = new File("03.jpg");

        // 2.创建输入流和输出流的对象
        FileReader f1 = null;
        FileWriter f2 = null;
        try {
            f1 = new FileReader(file1);
            f2 = new FileWriter(file2);

            // 3.操作
            char[] arr = new char[5];
            int len;
            while((len = f1.read(arr)) != -1){
                // 每次读出len个，并写出到file2中
                f2.write(arr,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 4.关闭资源
        try {
            f1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            f2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
