package ao.shang.cai.testfile;

import java.io.File;
import java.io.IOException;

/**
 * Created by 蔡尚澳 on 2016/7/12.
 */
public class TestFile {
    public static void main(String[] args) {
        File f1 = new File("H:/javacode_gaoqi/Welcome.java");
        File f2=new File("H:/javacode_gaoqi");
        File f3=new File("H:/javacode_gaoqi","Welcome.java");
        File f4 = new File("H:/javacode_gaoqi/testfile.java");
        File f5 = new File("H:/javacode_gaoqi/aaa/bbb/ccc/ddd");
//        try {
//            f4.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        f4.delete();
        f5.mkdirs();

        if (f3.isFile()) {
            System.out.println("是一个文件");

        }
        if (f2.isDirectory()) {
            System.out.println("是一个文件夹");
        }

    }
}
