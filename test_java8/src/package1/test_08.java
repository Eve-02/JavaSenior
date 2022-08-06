package package1;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class test_08 {

    /* 1.构造器引用: 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。抽象方法的返回值类型即为构造器所属的对 */
    // Supplier中的 T get()
    // person的 new person()
    public static void t1(){
        Supplier<person> sup1 = () -> new person();
        person person1 = sup1.get();
        System.out.println(person1);

        System.out.println("----------");

        Supplier<person> sup2 = person::new;
        package1.person person2 = sup2.get();
        System.out.println(person2);

    }

    // Function中的 R apply(T t)
    // peron的 person(int age)
    public static void t2(){
        Function<Integer,person> func1 = age -> new person(age);
        person apply1 = func1.apply(12);
        System.out.println(apply1);

        System.out.println("------------");

        Function<Integer,person> func2 = person::new;
        person apply2 = func2.apply(34);
        System.out.println(apply2);
    }

    // BiFunction中的 R Function(T t,U u)
    // person中的 new person(int age,Strign name)
    public static void t3(){
        BiFunction<Integer,String,person> bif1 = (age,name) -> new person(age,name);
        person p1 = bif1.apply(12, "张三");
        System.out.println(p1);

        System.out.println("------------");

        BiFunction<Integer,String,person> bif2 = person::new;
        person p2 = bif2.apply(45, "李四");
        System.out.println(p2);
    }

    // 数组引用: 把数组看成一个特殊的类.和构造器引用一致
    // Function中的 R apply(T t)
    public static void t4(){
        Function<Integer,String[]> func1 = lenght -> new String[lenght];
        String[] apply1 = func1.apply(10);
        System.out.println(apply1.length);

        System.out.println("--------");
        Function<Integer,String[]> func2 = String[]::new;
        String[] apply2 = func2.apply(12);
        System.out.println(apply2.length);
    }

    public static void main(String[] args) {
        t4();
    }
}
