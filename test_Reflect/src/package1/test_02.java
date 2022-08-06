package package1;

public class test_02 {

    public static void main(String[] args) throws ClassNotFoundException {
        /* 1: 调用运行时类的属性(.class) */
        Class clazz1 = person1.class;
        System.out.println(clazz1);

        /* 2: 调用运行时类的对象 */
        person1 p = new person1();
        Class clazz2 = p.getClass();
        System.out.println(clazz2);

        /* 3: 调用Class的静态方法 */
        Class clazz3 =  Class.forName("person1"); // 全类名(com.main.person)
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2); // true,
        // 通过不同的方式获取同一个运行时类(加载到内存中的运行时类，会缓存一定的时间，在此时间内，我们可以通过不同的方式来获取)

        /* 4: 使用类的加载器(ClassLoader) */
        ClassLoader classLoader = test_02.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("person1");
        System.out.println(clazz4);

    }

}

