package package2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class test_01 {

    public static void v(){
        Class clazz = person.class;

        /* 获取属性结构 */
        // 获取当前类及其父类中public权限的属性
        Field[] fields = clazz.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("-------");
        // 获取当前类中所有声明的属性(所有权限，不包含父类)
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field);
        }
        System.out.println("--------");
        // 获取属性中的结构：权限修饰符、返回值类型、方法名、修饰的注释等
        Field[] fields1 = clazz.getFields();
        for(Field field:fields1){
            System.out.println(field.getModifiers());
            System.out.println(field.getType());
            System.out.println(field.getName());
        }
    }

    public static void v1(){
       Class clazz =  person.class;

        /* 获取方法结构 */
        // 获取当前类及其父类中public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }
        System.out.println("-------");
        // 获取当前类中所有声明的方法(所有权限，不包含父类)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method method:declaredMethods){
            System.out.println(method);
        }

    }

    public static void v3(){
        Class clazz = person.class;

        // 获取方法中的结构：权限修饰符、返回值类型、方法名、修饰的注释等
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method method:declaredMethods){
            // 1.获取方法声明的注释
            Annotation[] annotations = method.getAnnotations();
            for(Annotation annotation:annotations){
                System.out.println(annotation);
            }
            // 2.权限修饰符
            System.out.println(Modifier.toString(method.getModifiers()) + "\t");
            // 3.返回值类型
            System.out.println(method.getReturnType().getName() + "\t");
            // 4.方法名
            System.out.println(method.getName());
            // 5.形参列表
            System.out.println("(");
            Class[] parameterTypes = method.getParameterTypes();
            if(!(parameterTypes==null || parameterTypes.length==0)){
                for(int i=0;i<parameterTypes.length;i++){
                    System.out.println(parameterTypes[i].getName() + "args_" + i);
                }
            }
            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        v3();
    }
}
