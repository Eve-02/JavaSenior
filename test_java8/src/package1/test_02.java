package package1;

import java.util.Comparator;

public class test_02 {

    public static void v1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门~");
            }
        };

        r1.run();

        System.out.println("------------");

        Runnable r2 = () -> System.out.println("我爱地球!");

        r2.run();
    }

    public static void v2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = com1.compare(12, 23);
        System.out.println(compare);

        System.out.println("----------------");

        /* Lambda表达式的写法 */
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com1.compare(61, 23);
        System.out.println(compare2);

        System.out.println("----------------");

        /* 方法引用 */
        Comparator<Integer> com3 = Integer :: compare;

        int compare3 = com1.compare(61, 62);
        System.out.println(compare3);

    }

    public static void main(String[] args) {
        v2();
    }
}
