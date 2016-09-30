package ao.shang.cai.factory.factoryMethod;


/**
 * 方法工厂模式 符合了OCP(开闭原则)
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client {
    public static void main(String[] args) {

        Car car1 = new CreatAudi().creatCar();
        Car car2 = new CreatByd().creatCar();

        car1.run();
        car2.run();
    }
}
