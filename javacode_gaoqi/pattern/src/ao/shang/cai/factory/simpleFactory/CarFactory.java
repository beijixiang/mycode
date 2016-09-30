package ao.shang.cai.factory.simpleFactory;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class CarFactory {

    public static Car creatCar(String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("比亚迪".equals(type)) {
            return new Byd();
        } else {
            return null;
        }
    }

}
