package package1;

public class person1 {

    private String name;
    public int age;

    public person1(){
        System.out.println("调用了此方法!");
    }

    public person1(String name, int age){
        this.name = name;
        this.age = age;
    }

    private person1(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("你好！我是人!");
    }

    private String show_123(String str){
        System.out.println(str+"show_123");
        return "ooo";
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
