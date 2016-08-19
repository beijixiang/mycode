package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/8/8.
 */
public class Demo01 {
    static {
        System.out.println("静态初始化Demo01");

    }

    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("Demo01的main方法");
//        A a = new A();
//        System.out.println(A.width);
//        A a2 = new A();

//        主动引用
//        new A();    //new 一个类的对象
//        System.out.println(A.width);    //调用静态变量或方法（final常量除外）
//        Class clazz = Class.forName("ao.shang.cai.test.A"); //反射调用


//        被动引用
//        System.out.println(A.MAX);      //final常量作为常量池不会初始化类
//        A[] as = new A[10]; //数组的引用
        System.out.println(B.width);    //只有真正声明的静态域才会被初始化

    }

}

class B extends A {
    static {
        System.out.println("静态初始化B");

    }
}

class A extends A_Father {

    public static int width = 100;
    public static final int MAX = 100;

    static {
        System.out.println("静态初始化A");
        width = 300;

    }

    public A() {
        System.out.println("创建A的对象");

    }

}
//加载类对象的时候如果其父类对象还未初始化则先初始化该类的父类
class A_Father{
    static {
        System.out.println("静态初始化A_Father");

    }
}
