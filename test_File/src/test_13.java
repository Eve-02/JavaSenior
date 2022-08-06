import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class test_13 {

    public static void main(String[] args) throws IOException {

        FileInputStream f1 = new FileInputStream("01.jpg");
        FileWriter f2 = new FileWriter("02.text");

        byte[] b = new byte[100];
        int len;
        while((len = f1.read(b)) != -1){
            for(int i=0;i<len;i++){
                f2.write(b[i]+"");
            }
            f2.write("\n");
        }
        f1.close();
        f2.close();
    }
}
