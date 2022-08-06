import java.util.ArrayList;
import java.util.Iterator;

public class test_02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(67);
        list.add(89);
        list.add(64);
        list.add(99);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
