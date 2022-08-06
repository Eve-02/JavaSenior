package package1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class test_05 {

    public static void t1(double money, Consumer<Double> con){
        con.accept(money);
    }

    public static List<String> t2(List<String> list, Predicate<String> pre){
        // 根据给定的pre规则来过滤字符串
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                list1.add(s);
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        /* 1.Consumer */
        t1(100, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费了"+ aDouble + "r");
            }
        });

        System.out.println("----------");

        t1(100,aDouble -> System.out.println("消费了"+ aDouble + "r"));

        System.out.println("-----------");


        /* 2.Predicate */
        List<String> list = new ArrayList<>();
        list.add("ad");
        list.add("abc");
        list.add("fwf");
        list.add("w");

        List<String> strings = t2(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() >= 2;
            }
        });
        System.out.println(strings);

        System.out.println("------------");

        List<String> strings1 = t2(list, s -> s.length() >= 2);
        System.out.println(strings1);

    }

}

