package package1;

public class test_03 {

    private static int n;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class clazz = person1.class;
        /*
            newInstance(): 调用此方法，创建对应运行时类的对象，内部调用了此运行时类的空参构造器
            1.运行时类需提供空参构造器
            2.空参构造器访问权限得够
         */
        person1 p = (person1)clazz.newInstance();
    }

}
