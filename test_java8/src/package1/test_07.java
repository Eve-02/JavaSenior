package package1;

import java.util.Comparator;
import java.util.function.Function;

public class test_07 {


    /* 情况2: 类 :: 静态方法 */
    // Comparator中的 int compare(T t1,T t2)
    // Integer中的 int compare(T t1,T t2)
    public static void t1(){
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 13));

        System.out.println("------------");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(13, 12));
        // Function中的 R apply(T t)
        // Math中的 Long Math(Double d)
    }

    /* 情况3 类 :: 非静态方法 */
    // Comparator中的 int compara(T t1,T t2)
    // String中的 int t1.compareTo(t2)
    public static void t2(){
        Comparator<String> com1 = (t1,t2) -> t1.compareTo(t2);
        System.out.println(com1.compare("abc", "ade"));

        System.out.println("------------");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("ade", "abc"));
    }

    // Function中的 R apply(T t)
    // person中的 String getName()
    public static void t3(){
        person p = new person(12,"李四");
        Function<person,String> func1 = e -> e.getName();
        System.out.println(func1.apply(p));

        System.out.println("-------------");

        Function<person,String> func2 = person::getName;
        System.out.println(func2.apply(p));
    }

    public static void main(String[] args) {
        t3();
    }
}
