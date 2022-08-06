import java.io.*;

public class test_09 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        copyFile1("01.jpg","03.jpg");

        long end = System.currentTimeMillis();

        System.out.println((end - start) + "ms");

    }

    public static void copyFile1(String scrPath,String destPath){
        // 1.File对象
        File file1 = new File(scrPath);
        File file2 = new File(destPath);

        // 2.流
        // 文件流、处理流
        FileInputStream f1 = null;
        FileOutputStream f2 = null;
        BufferedInputStream b1 = null;
        BufferedOutputStream b2 = null;
        try {
            f1 = new FileInputStream(file1);
            f2 = new FileOutputStream(file2);
            // 缓冲流
            b1 = new BufferedInputStream(f1);
            b2 = new BufferedOutputStream(f2);

            // 3.操作
            byte[] arr = new byte[10];
            int len;
            while((len = b1.read(arr)) != -1){
                b2.write(arr,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(b1 != null){
                    b1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(b2 != null){
                    b2.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void copyFile2(String scrPath,String destPath) {
        // 1.File对象
        File file1 = new File(scrPath);
        File file2 = new File(destPath);

        // 2.流
        // 文件流、处理流
        FileInputStream f1 = null;
        FileOutputStream f2 = null;
        try {
            f1 = new FileInputStream(file1);
            f2 = new FileOutputStream(file2);

            // 3.操作
            byte[] arr = new byte[10];
            int len;
            while ((len = f1.read(arr)) != -1) {
                f2.write(arr, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (f1 != null) {
                    f1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (f2 != null) {
                    f2.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
