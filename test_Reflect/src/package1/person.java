package package1;
import java.io.Serializable;

public class person<T> implements Serializable {

    private int age;
    private String name;

    public void v(){
        System.out.println("是人");
    }

    public void v1(){
        System.out.println("睡觉");
    }
}

