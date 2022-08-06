package package2;


public class person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public person(){

    }

    public static void ss(){
        System.out.println("这是静态方法~");
    }

    private person(String name){
        this.name = name;
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String uu(String iii){
        return iii;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void Info() {
        System.out.println("我是一个人~");
    }

    private void show(String show){
        System.out.println("show: " + show);
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
