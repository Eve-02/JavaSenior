import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test_04 {

    public static void main(String[] args) throws IOException {
        // 1.File的实例化
        File file = new File("tc01.text");

        // 2.流的实例化
        FileWriter f = new FileWriter(file,false); // 默认，FileWriter f = new FileWriter(file);

        // 3.写出的操作
        String str = "abc123";
        f.write(str);
        f.write("uio  ");

        // 4.关闭资源
        f.close();
    }
}
