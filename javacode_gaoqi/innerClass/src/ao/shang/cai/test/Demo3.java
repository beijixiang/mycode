package ao.shang.cai.test;

import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/8/9.
 */
public class Demo3 {

    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        Outer03.InnerClass innerClass = outer03.new InnerClass();
        innerClass.test();
    }
}

class Outer03{
    private int a = 3;
    int b = 10;


    public void ttt(){
        InnerClass innerClass = new InnerClass();
    }

    public class InnerClass{
        final static int d = 10;    //不允许有静态变量,除非是final修饰的常量
//        final static Date date = new Date();

        void test(){
            System.out.println(a);
            System.out.println("内部类对象" + this);
            System.out.println("外部类对象" + Outer03.this);
        }
    }


}