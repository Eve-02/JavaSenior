package package2;

import java.util.List;
import java.util.stream.Stream;

public class test_05 {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();

        // 1.allMatch(Predicate p):
        // 是否所有员工的年龄都大于18
        System.out.println(employees.stream().allMatch(employee -> employee.getAge() > 18)); // false

        // 2.anyMatch(Predicate p):
        // 判断是否至少一个工资大于9000
        System.out.println(employees.stream().anyMatch(employee -> employee.getSalary() > 9000)); // true

        // 3.noneMatch(Predicate p)
        // 是否所有员工都不小于18
        System.out.println(employees.stream().noneMatch(employee -> employee.getSalary() < 2000)); // true

        // 4.findFirst()
        System.out.println(employees.stream().sorted().findFirst()); // Optional[Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}]

        // 5.findAny()
        System.out.println(employees.stream().findAny()); // Optional[Employee{id=1001, name='马化腾', age=34, salary=6000.38}]

        // 6.count()
        System.out.println(employees.stream().filter(e -> e.getSalary()>5000).count()); // 5

        // 7.max(Comparator c)
        System.out.println(employees.stream().max(Employee::compareTo)); // Optional[Employee{id=1002, name='马云', age=12, salary=9876.12}]

        // 8.min(Comparator c)
        System.out.println(employees.stream().filter(e -> e.getName().length()>2).min(Employee::compareTo)); // Optional[Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}]
        // 返回最低的工资
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        System.out.println(doubleStream.min(Double::compareTo));

        // 9.forEach(Consumer c)
        employees.stream().filter(e -> e.getAge()>20).forEach(System.out::println); // ...
        employees.forEach(System.out::println);
    }
}
