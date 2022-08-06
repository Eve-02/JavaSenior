import java.util.List;

class person{

}
class student extends person{

}
public class test_05 {

    public void v(List<? extends student> list){
        for (student student : list) {
            System.out.println(student);
        }
    }

    public void v1(List<? super student> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}


