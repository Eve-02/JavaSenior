import java.io.*;

public class test_14 {

    public static void main(String[] args){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("我爱北京天字门!"));

            oos.flush(); // 清空缓冲区
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null){
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
