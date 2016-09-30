package cn.bjsxt.opp.abstractClass;



/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public abstract class Animal {  //抽象类的意义在于，将方法设计与方法实现相分离
    public abstract void run();
    public void breath(){
        System.out.println("呼吸");
        run();
    }

    public Animal(){
        System.out.println("创造一个动物对象");
    }
}

class Cat extends Animal{

    @Override
    public void run() {
        System.out.println("猫步跑跑");
    }
}

class Dog extends Animal{

    @Override
    public void run() {
        System.out.println("狗跑");
    }
}
