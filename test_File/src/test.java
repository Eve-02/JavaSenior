import java.io.File;

public class test {

    public static void main(String[] args) {

        File file1 = new File("hello.text"); // 文件(相对路径)
        File file2 = new File("D:\\workspace\\hello.text"); // 文件(绝对路径)
        File file3 = new File("D:\\wordspace","test_File"); // 文件夹
        File file4 = new File(file3,"hi.text"); // 文件夹file3下面的一个文件

        System.out.println(file1);
        System.out.println(file2); // 内存中的对象，toString()方法输出文件路径
        System.out.println(file3);
        System.out.println(file4);
    }

}
