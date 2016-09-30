package ao.shang.cai.testexception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 蔡尚澳 on 2016/7/12.
 */
public class TestReadFile {
    public static void main(String[] args) {
        FileReader reader=null;
        try {
            reader=new FileReader("H:/javacode_gaoqi/a.txt");
            char c=(char) reader.read();
            char c2=(char) reader.read();
            System.out.println(""+c+c2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str=new TestReadFile().OpenFile();
        System.out.println(str);

    }

    String OpenFile()  {
        System.out.println("aaaa");


        try {
            FileInputStream reader=new FileInputStream("H:/javacode_gaoqi/a.txt");
            char c=(char) reader.read();
            System.out.println("bbbb");
            return "step1";
        } catch (IOException e) {
            System.out.println("catching!!!!!");
            e.printStackTrace();
            return "step2";
        }finally {
            System.out.println("finally!!!!!");
//            return "fffff";   //一般不加return
        }
    }
}



