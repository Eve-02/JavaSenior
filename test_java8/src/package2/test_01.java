package package2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test_01 {


    // 1.通过集合
    public static void t1(){
        List<Employee> employees = EmployeeData.getEmployees();

        // default Stream<E> stream(): 返回一个顺序流
        Stream<Employee> stream = employees.stream(); // 按顺序取数据

        // default Stream<E> parallelStream(): 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream(); // 并行取数据，通过线程
    }

    // 2.通过数组
    public static void t2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        // 调用Arrays.类static <T> Stream <T> stream(T[]array):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1,"a",12,12);
        Employee e2 = new Employee(2,"b",13,22);
        Employee[] employees = new Employee[]{e1,e2};

        Stream<Employee> stream1 = Arrays.stream(employees);

    }

    // 3.Stream.of()
    public static void t3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    public static void main(String[] args) {
        t3();
    }
}
