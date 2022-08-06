package package2;

import java.lang.reflect.Field;

public class test_02 {

    // 调用属性
    public static void v() throws Exception {
        Class clazz = person.class;

        // 该方法要求属性为public，因此不太常用
        Field id = clazz.getField("id");
        person p = (person)clazz.newInstance();
        // get: 获取那个对象的值
        int p_id = (int)id.get(p);
        System.out.println(p_id);
        // set：设置那个对象的值
        id.set(p,123);
        System.out.println(p.id);
        System.out.println("-----------");
    }

    public static void v1() throws Exception {
        Class clazz = person.class;

        /* 获取指定变量名的属性 */
        // public以下的权限get、set都需要设置: name.setAccessible(true); // 可访问
        Field name = clazz.getDeclaredField("name");
        person p = (person)clazz.newInstance();

        name.setAccessible(true);
        name.set(p,"qwe");
        System.out.println(name.get(p));
    }

    public static void main(String[] args) throws Exception {
        v1();
    }
}
