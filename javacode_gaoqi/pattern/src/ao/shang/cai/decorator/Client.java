package ao.shang.cai.decorator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        System.out.println("-----------增加新功能：飞翔");

        FlyCar flyCar = new FlyCar(car);
        flyCar.move();
        System.out.println("---------增加新功能，水里游");
        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();

        System.out.println("增加两个新的功能，天上飞和水里游");

        WaterCar waterCar1 = new WaterCar(new FlyCar(car));
        waterCar1.move();
    }
}
