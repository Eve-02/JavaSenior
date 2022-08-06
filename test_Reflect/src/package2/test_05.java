package package2;

public class test_05 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("package2.person");
        Object o = clazz.newInstance();
        System.out.println(o);
        person p = new person();
        System.out.println(p.getClass().getName());
    }
}
