package package1;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class test_06 {

    /*
        方法引用的使用
        1.使用情境: Lambda体的操作已经有实现的方法，可以使用方法引用
        2.方法引用: 本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例，所以方法引用，也是函数式接口的实例
        3.使用格式: 类(或对象) :: 方法名
        4.具体分为如下三种情况:
            对象 :: 非静态方法
            类   :: 静态方法
            类   :: 非静态方法
        5.方法引用的要求: 要求接口中的抽象方法形参列表和返回值类型与方法引用中的形参列表和返回值类型相同
     */

    // Consumer中的 void accept(T t)
    // PrintStream中的 void println(T t)
    public static void t1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("abc");

        System.out.println("---------------");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("123");
    }

    // Supplier中的 T get()
    // person中的 String getName()
    public static void t2(){
        person p = new person(12,"张三");
        Supplier<String> sup1 = () -> p.getName();
        System.out.println(sup1.get());

        System.out.println("--------------");

        Supplier<String> sup2 = p::getName;
        System.out.println(sup2.get());
    }

    public static void main(String[] args) {
        t2();
    }
}
