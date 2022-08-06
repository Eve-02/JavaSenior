import java.util.ArrayList;

public class test_01 {

    public static void test_01(){
        ArrayList list = new ArrayList();
        list.add(67);
        list.add(89);
        list.add(64);
        list.add(99);
        // 问题一：类型不安全
        list.add("78");
        for (Object o : list) {
            int score = (Integer) o;
            System.out.println(score);
        }
    }
}
