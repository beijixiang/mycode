package cn.bjsxt.opp.test;

/**
 * Created by 蔡尚澳 on 2016/7/6.
 */
public class test02 {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.name = "蔡尚澳";
        s1.age=18;

        Computer c=new Computer();
        c.brend = "联想";
        c.cpuspeed=100;

        s1.computer=c;
        c.brend = "dell";

        System.out.println(s1.computer.brend);

    }
}
