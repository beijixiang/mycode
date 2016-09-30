package ao.shang.cai.io.others;

import java.io.*;

/**
 * PrintStream类
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class PrintDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("test");
        PrintStream ps = System.out;
        ps.print("hehe");

//        输出到文件中
        File dest = new File("H:/javacode_gaoqi/print.txt");
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(dest)));
        ps.println("io is so easy");

        ps.close();

    }
}
