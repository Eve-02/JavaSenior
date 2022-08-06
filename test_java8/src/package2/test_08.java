package package2;

import java.util.Optional;

public class test_08 {

    public static void newOptional(){
        // 实例化
        Employee e = new Employee();
        Optional<Employee> optional1 = Optional.of(e);
        Optional<Employee> optional2 = Optional.empty();
        Optional<Employee> optional3 = Optional.ofNullable(e); // return value == null ? empty() : of(value);
    }

    public static String getEmployeeName(Employee employee){
        return employee.getName();
    }

    // 未使用Optional
    public static void t1(){
        Employee e = null;
        if(e != null){
            getEmployeeName(e);
        }
    }

    // 使用Optional
    public static void t2(){
        Employee e = null;
        Optional<Employee> e1 = Optional.ofNullable(e);
        System.out.println(getEmployeeName(e1.orElse(new Employee(1, "12", 34, 23)))); // 如果不为空，返回T other
    }

    public static void main(String[] args) {
        t2();
    }
}
