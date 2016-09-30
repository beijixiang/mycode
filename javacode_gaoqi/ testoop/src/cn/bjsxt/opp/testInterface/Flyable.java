package cn.bjsxt.opp.testInterface;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public interface Flyable {
    int MAX_SPEED=11000;
    int MIN_HIGHT=1;

    void fly();
}

interface Attack{
    void attack();
}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("飞机用发动机飞行");
    }
}

class Man implements Flyable{

    @Override
    public void fly() {
        System.out.println("跳起来，飞");
    }
}

class Stone implements Flyable,Attack{

    @Override
    public void fly() {
        System.out.println("扔出去飞");
    }

    @Override
    public void attack() {
        System.out.println("石头攻击");
    }
}