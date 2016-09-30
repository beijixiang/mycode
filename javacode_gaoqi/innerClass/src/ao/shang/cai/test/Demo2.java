package ao.shang.cai.test;


import ao.shang.cai.test.Outer02;

/**
 *
 * 静态内部类具体使用
 * Created by 蔡尚澳 on 2016/8/9.
 */
public class Demo2 {

    Outer02.StaticInnerClass outer02 = new Outer02.StaticInnerClass();

}

class Outer02{

    int c = 5;
    static int d = 10;

    //    静态内部类
    public static class StaticInnerClass{
        int a = 3;
        static int b = 5;

        public void test(){
//        System.out.println(c);    //不能使用外部的非静态属性s
            System.out.println(d);

        }

    }


}
