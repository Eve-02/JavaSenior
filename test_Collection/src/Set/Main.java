package Set;

import java.util.HashSet;

@SuppressWarnings({"all"})
public class Main {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("java");
        set.add("php");
        set.add("java");
        System.out.println("set=" + set);
    }
}
