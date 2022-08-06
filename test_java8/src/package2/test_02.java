package package2;

import java.util.List;
import java.util.stream.Stream;

public class test_02 {


    public static void main(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();

        // 1.filter(Predicate p)
        Stream<Employee> stream = list.stream();
        // 查询工资大于7000的员工
        stream.filter(e -> e.getSalary()>7000).forEach(System.out::println);

        System.out.println("-----------");

        // 2.limit(long maxSize)
        Stream<Employee> stream1 = list.stream();
        stream1.limit(3).forEach(System.out::println);

        System.out.println("-----------");

        // 3.skip(long n)
        Stream<Employee> stream2 = list.stream();
        stream2.skip(3).forEach(System.out::println);

        System.out.println("-----------");

        // 4.distinct()
        list.add(new Employee(1001,"马化腾",45,4000));
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("我是分割线~");
        Stream<Employee> stream3 = list.stream();
        stream3.distinct().forEach(System.out::println);
    }
}
