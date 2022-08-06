package package1;

public class test_04 {

    public static void main(String[] args) {
        MyInterface my = () -> System.out.println("gjg");
        my.method1();
    }
}

@FunctionalInterface
interface MyInterface{

    void method1();

}
