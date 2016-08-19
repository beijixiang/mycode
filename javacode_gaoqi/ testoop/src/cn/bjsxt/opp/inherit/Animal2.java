package cn.bjsxt.opp.inherit;

/**
 * 测试组合
 * Created by 蔡尚澳 on 2016/7/8.
 */
public class Animal2 {
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

    public  Animal2(){
        super();
        System.out.println("创建一个动物");
    }

    public static void main(String[] args) {
        bird2 bird2=new bird2();
        bird2.run();
        bird2.animal2.eat();
    }

}

class Mammal2 {

    Animal2 animal2=new Animal2();

    public void taisheng(){
        System.out.println("胎生");
    }



}

class bird2 {

    Animal2 animal2=new Animal2();

    public void run(){
        animal2.run();
        System.out.println("小小鸟");
    }

    public bird2(){
        super();
        System.out.println("创造一只鸟");
    }


    public void eggsheng(){
        System.out.println("卵生");
    }
}
