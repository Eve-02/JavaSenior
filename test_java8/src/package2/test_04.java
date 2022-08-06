package package2;

import java.util.Arrays;
import java.util.List;

public class test_04 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 45, 2, 12, 6, 90);

        // 1.自然排序
        list.stream().sorted().forEach(System.out::println);
        List<Employee> employees= EmployeeData.getEmployees();
        employees.stream().sorted().forEach(System.out::println);

        // 2.定制排序
        employees.stream().sorted((e1,e2) ->{
            int i = Integer.compare(e1.getAge(),e2.getAge());
            return i!=0?i:e1.getName().compareTo(e2.getName());
        }).forEach(System.out::println);
    }
}
