package ao.shang.cai.factory.simpleFactory;

/**
 * 使用工厂模式情况下
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client2 {
    public static void main(String[] args) {

        Car car1 = CarFactory.creatCar("奥迪");
        Car car2 = CarFactory.creatCar("比亚迪");

        car1.run();
        car2.run();



    }


}
