import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test_08 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        copy_File("02.jpg","03.jpg");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    // 指定目录下的文件复制操作
    public static void copy_File(String scrPath,String destPath){
        // 1.创建读入的File对象和写出的File对象
        File file1 = new File(scrPath);
        File file2 = new File(destPath);

        // 2.创建输入流和输出流的对象
        FileInputStream f1 = null;
        FileOutputStream f2 = null;
        try {
            f1 = new FileInputStream(file1);
            f2 = new FileOutputStream(file2);

            // 3.操作
            byte[] arr = new byte[5];
            int len;
            while((len = f1.read(arr)) != -1){
                // 每次读出len个，并写出到file2中
                f2.write(arr,0,len);
            }
            System.out.println("复制成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4.关闭资源
            try {
                if(f1 != null){
                    f1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(f2 != null){
                    f2.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
