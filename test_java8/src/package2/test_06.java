package package2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test_06 {

    public static void main(String[] args) {
        // 1.reduce(T iden,BinaryOperator b)
        // 计算1-10的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().reduce(0, Integer::sum));
        // 计算所有员工工资和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        System.out.println(doubleStream.reduce(0.0, Double::sum));
    }
}
