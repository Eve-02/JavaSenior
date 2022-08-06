import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class test_15 {

    public static void main(String[] args) {
        ObjectInputStream ois = null;
        String str = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            str = (String)ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null){
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(str);

    }
}
