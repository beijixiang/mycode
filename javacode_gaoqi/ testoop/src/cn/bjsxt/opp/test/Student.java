package cn.bjsxt.opp.test;

/**
 * Created by 蔡尚澳 on 2016/7/5.
 */
public class Student {
//    静态数据
    String name;
    int age;
    int weight;
    int id; //学号
    String genter;
    Computer computer;


//    动态方法
    public  void study(){
        System.out.println(name+"在学习");
    }
    public void sayHello(String sname){
        System.out.println(name+"向"+sname+"说：你好");
    }


}
