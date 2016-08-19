package cn.bjsxt.opp.polimorphism.testServilet;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class Test {
    public static void main(String[] args) {
        HttpServilet s=new MyServilet();
        s.doGet();
    }
}
