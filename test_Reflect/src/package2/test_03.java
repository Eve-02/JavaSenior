package package2;

import java.lang.reflect.Method;

public class test_03 {

    public static void v() throws Exception{
        Class clazz = person.class;

        /* 获取指定的某个方法 */
        // 指明方法名和参数 // 方法若为public权限以下，也需要设置: method.setAccessible(ture); 可访问
        person p = (person)clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        show.invoke(p,"wefwefwef");
        System.out.println("-------");
        Method uu = clazz.getDeclaredMethod("uu", String.class);
        uu.setAccessible(true);
        String invoke = (String)uu.invoke(p, "123");
        System.out.println(invoke);

        // 静态方法的调用
        Method ss = clazz.getDeclaredMethod("ss");
        ss.setAccessible(true);
        ss.invoke(person.class);
    }

    public static void main(String[] args) throws Exception{
        v();
    }
}
