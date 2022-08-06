package package1;

import java.util.Comparator;
import java.util.function.Consumer;

public class test_03 {

    // 1.举例: (o1,o2) -> Integer.compare(o1,o2);
    // 2.格式:
    //      -> :Lambda操作符，或 箭头操作符
    //          左边：Lambda形参列表(其实是接口中的抽象方法的形参列表)
    //          右边：Lambda体(其实是重写抽象方法的方法体)
    // 3.使用: 分为6种情况(格式)介绍
    //      * 左边：Lambda形参列表的参数类型可以省略; Lambda若只有一个参数，可以省略小括号
    //      * 右边：Lambda体应使用一对大括号包裹；Lambda体若只有一条执行语句(包含return语句),可以省略该大括号和return关键字(省略大括号则必须省略return);
    // 4.本质: 作为接口的实例(实现类对象)[只有一个抽象方法，也称为函数式接口]

    /* 1.无参无返回值 */
    public static void t1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门~");
            }
        };
        r1.run();

        System.out.println("------------");

        Runnable r2 = () -> {
            System.out.println("我爱地球!");
        };
        r2.run();
    }

    /* 2.有参数无返回值 */
    public static void t2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("abc");

        System.out.println("-------------");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("def");
    }

    /* 3.数据类型可以省略，因为可由编译器推断得出，称为 “类型推断” */
    public static void t3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("def");

        System.out.println("-------------");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con1.accept("def2");
    }

    /* 4.Lambda若需要一个参数，参数的小括号可以省略 */
    public static void t4(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("def1");

        System.out.println("----------");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con1.accept("def2");
    }

    /* 5.Lambda若需要两个或以上的参数，多条执行语句，并且可以有返回值 */
    public static void t5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        System.out.println("-----------");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 21));
    }

    /* 6.若Lambda体只有一条语句时，return与大括号若有，都可以省略 */
    public static void t6(){
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 21));

        System.out.println("-------------");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12, 21));
    }


    public static void main(String[] args) {
        t6();
    }
}
