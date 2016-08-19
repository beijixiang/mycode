package ao.shang.cai.io.others;

import java.io.*;
import java.util.Scanner;

/**
 * 三个常量
 * in
 * out
 * err
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class SystemDemo1 {
    public static void main(String[] args) throws FileNotFoundException {

//        test1();
//        test2();
//        从控制台-->文件
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("H:/javacode_gaoqi/print.txt")),true));
        System.out.println("dasdsdfasf");
        System.out.println("test");
//        会控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
        System.out.println("dddd");
    }

    public static void test2() throws FileNotFoundException {

        InputStream is = System.in; //键盘输入
//        从文件读入
        is = new BufferedInputStream(new FileInputStream("H:/javacode_gaoqi/print.txt"));
        Scanner sc = new Scanner(is);
        System.out.println("请输入：");
        System.out.println(sc.nextLine());
    }

    public static void test1(){
        System.out.println("dddd");
        System.err.println("err");
    }
}
