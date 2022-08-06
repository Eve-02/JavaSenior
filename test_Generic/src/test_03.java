import java.util.*;

public class test_03 {
    public static void main(String[] args) {
//        Map<String,Integer> map = new HashMap<String,Integer>();
//        map.put("张三",56);
//        map.put("李四",67);
//        map.put("小红",89);
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        test();
    }

    public static void test(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(47);
        Integer integer = list.get(0);
        System.out.println(integer);
    }
}

