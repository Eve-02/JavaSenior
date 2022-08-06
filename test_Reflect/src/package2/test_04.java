package package2;

import java.lang.reflect.Constructor;

public class test_04 {

    public static void v() throws Exception{
        /* 获取指定的某个构造器 */
        // 指定构造器中的形参列表
        Class clazz = person.class;
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        // 创建对象：指定参数值
        person p = (person)declaredConstructor.newInstance("abc", 123);
        System.out.println(p);
    }

    public static void main(String[] args) throws Exception{
        v();

    }
}
