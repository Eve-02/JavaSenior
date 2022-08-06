package package1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test_01 {

    public static void main(String[] args) throws Exception {
        Class clazz = person1.class;
        // 1.通过反射创建对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object ab = constructor.newInstance("ab",12);
        person1 p = (person1)ab;
        System.out.println(p);
        System.out.println("-----------");

        // 2.通过反射，调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        System.out.println("-----------");

        // 3.通过反射获得私有结构：构造器、属性、方法
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        person1 p1 = (person1)constructor1.newInstance("cd");
        System.out.println(p1);
        System.out.println("-----------");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"adef");
        System.out.println(p1);
        System.out.println("-----------");
        Method show_123 = clazz.getDeclaredMethod("show_123",String.class);
        show_123.setAccessible(true);
        Object wefwef = show_123.invoke(p1, "wefwef");
        System.out.println(wefwef);
    }
}

