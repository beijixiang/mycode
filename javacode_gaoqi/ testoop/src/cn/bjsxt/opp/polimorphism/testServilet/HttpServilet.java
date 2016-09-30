package cn.bjsxt.opp.polimorphism.testServilet;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class HttpServilet {
    public void service(){
        System.out.println("HttpServilet.service");
        doGet();
    }
    public void doGet(){
        System.out.println("HttpServilet.doGet");
    }
}
