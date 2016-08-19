package cn.bjsxt.opp.inherit;

/**
 *
 * 测试继承
 * Created by 蔡尚澳 on 2016/7/7.
 */
public class Animal {
    String eye;

    public void run(){
        System.out.println("跑跑！！");
    }

    public void eat(){
        System.out.println("吃吃吃");
    }

    public void sleep(){
        System.out.println("zzzzzzz");
    }

    public  Animal(){
        super();
        System.out.println("创建一个动物");
    }



}

 class Mammal extends Animal{

     public void taisheng(){
         System.out.println("胎生");
     }



 }

class bird extends Animal{

    public void run(){
        super.run();
        System.out.println("小小鸟");
    }

    public bird(){
        super();
        System.out.println("创造一只鸟");
    }


    public void eggsheng(){
        System.out.println("卵生");
    }
}