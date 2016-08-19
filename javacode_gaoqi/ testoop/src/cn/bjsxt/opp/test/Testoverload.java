package cn.bjsxt.opp.test;

/**
 * Created by 蔡尚澳 on 2016/7/7.
 */
public class Testoverload {
    public static void main(String[] args) {
        MyMath m = new MyMath();
        int result = m.add(4.5,4);
        System.out.println(result);
    }
}


class MyMath{
       public int add(double a,int b) {
           return (int)(a+b);
       }
    public int add(int a,int b,int c){
        return a+b+c;
    }
}