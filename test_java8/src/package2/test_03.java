package package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test_03 {

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list= new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    public static void main(String[] args) {
        // 1.map(Function f)
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("---------");

        // 获取名字大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(str -> str.length()>3).forEach(System.out::println);

        System.out.println("---------");

        // 将流中的每个元素取出到一个流中
        Stream<Stream<Character>> streamStream = strings.stream().map(test_03::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));

        System.out.println("---------");

        // 2.flatMap(Function f)
        Stream<Character> characterStream = strings.stream().flatMap(test_03::fromStringToStream);
        characterStream.forEach(System.out::println);

    }
}
