public class test_04<T> {

    int id;
    T t;
    String name;

    public test_04(){}

    public test_04(int id, T t, String name) {
        this.id = id;
        this.t = t;
        this.name = name;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        test_04<Integer> t1 = new test_04<>();
    }

}

