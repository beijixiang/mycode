package ao.shang.cai.factory.factoryMethod;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class CreatAudi implements CarFactory {

    @Override
    public Car creatCar() {
        return new Audi();
    }
}
