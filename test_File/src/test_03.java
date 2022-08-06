import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test_03 {

    public static void main(String[] args)  {
        // 1.File实例化
        File file = new File("tc.text");

        // 2.流的实例化
        FileReader f = null;
        try {
            f = new FileReader(file);

            // 3.读入的操作
            // read(char[] arr): 返回每次读入数组中字符的个数，达到末尾返回-1
            char[] arr = new char[5];
            int len;
            while((len = f.read(arr)) != -1){
                for(int i=0;i<len;i++){
                    System.out.print(arr[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            // 4.流的关闭
            try {
                f.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
