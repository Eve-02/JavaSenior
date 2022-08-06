import java.io.*;

public class test_16 {

    public static void main(String[] args) {
        // 序列化
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new person("张三",19));

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

        // 反序列化
        ObjectInputStream ois = null;
        person p = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            p = (person)ois.readObject();
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
        System.out.println(p);
    }
}

class person implements Serializable {

    private static final long serialVersionUID = 8493754667710L;

    private String name;
    private int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}