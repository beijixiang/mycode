package ao.shang.cai;

import java.util.Scanner;

/**
 * Created by 蔡尚澳 on 2016/7/4.
 */
public class TestScanner {
    public static void test01() {
        Scanner s = new Scanner(System.in);
        String str = s.next();    //程序运行到next会阻塞，等待键盘输入
        System.out.println("刚刚输入的是：" + str);
    }

    public static void test02() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个加数");
        int a=s.nextInt();
        System.out.println("输入另一个加数");
        int b = s.nextInt();
        int sum=a+b;
        System.out.println("两个加数和为"+sum);
    }


    public static void main(String[] args) {
        test02();
    }
}
