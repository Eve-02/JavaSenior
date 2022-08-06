import java.io.*;

public class test_10 {

    public static void main(String[] args){

        copyFile1("tc.text","tc1.text");

    }
    public static void copyFile1(String srcPath,String destPath){

        BufferedReader b1 = null;
        BufferedWriter b2 = null;
        try {
            b1 = new BufferedReader(new FileReader(new File(srcPath)));
            b2 = new BufferedWriter(new FileWriter(new File(destPath)));

            String date;
            while((date = b1.readLine()) != null){
                b2.write(date + "\n"); // date中不包括换行符
                // 或者 b2.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(b1 != null){
                    b1.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(b2 != null){
                    b2.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
