package cn.bjsxt.opp.testthis;

/**
 * Created by 蔡尚澳 on 2016/7/5.
 */
public class Student {

    String name;
    int id;


    public Student(String name,int id){
        this(name);
        this.name=name;
        this.id=id;

    }

    public Student(){
        System.out.println("构造一个对象");
    }

    public Student(String name){
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

    public  void study(){
        this.name="张三";
        System.out.println(name+"在学习");
    }
    public void sayHello(String sname){
        System.out.println(name+"向"+sname+"说：你好");
    }


}
