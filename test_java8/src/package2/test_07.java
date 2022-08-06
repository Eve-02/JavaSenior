package package2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class test_07 {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        // 查找工资大于6000的员工，将结果返回一个list或set
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 7000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("-----------");

        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 7000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);

    }
}
