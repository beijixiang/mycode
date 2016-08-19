package ao.shang.cai.factory.simpleFactory;

/**
 * 没有使用工厂模式情况下
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client {
    public static void main(String[] args) {
        Car car1 = new Audi();
        Car car2 = new Byd();

        car1.run();
        car2.run();


    }


}
