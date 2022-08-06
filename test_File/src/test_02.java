import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test_02 {

    public static void main(String[] args) {
        // 1.实例化File对象，指明要操作的对象
        File file1 = new File("tc.text");
        FileReader f = null;
        try {
            System.out.println(file1.createNewFile());

            // 2.提供具体的流
            f = new FileReader(file1);

            // 3.数据的读入
            // 方式一
//        int read = f.read();
//        while(read != -1){
//            System.out.print((char)read);
//            read = f.read();
//        }
            // 方式二
            int date;
            while((date = f.read()) != -1){
                System.out.print((char)date);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            // 4.流的关闭
            try {
                if(f != null){
                    f.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
