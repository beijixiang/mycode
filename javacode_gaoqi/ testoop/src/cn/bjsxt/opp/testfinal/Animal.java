package cn.bjsxt.opp.testfinal;

/**
 *
 * 测试继承
 * Created by 蔡尚澳 on 2016/7/7.
 */
public  /*final*/ class Animal { //final加在类前面表示该类不能被继承
    String eye;

    public /*final*/ void run() { //final被加在方法前，表示该方法不能被重写
        System.out.println("跑跑！！");
    }

}

class bird extends Animal {

    public void run(){
        super.run();
        System.out.println("小小鸟");
    }
}