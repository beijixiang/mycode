package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/8/9.
 */
public class Demo05 {

    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.test();
    }

}

class Outer05{

    public void test02(Car car) {
        car.run();
    }

    public void test(){

//        接口式匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


            }
        };

//        继承式匿名内部类
        Car car = new Car() {

            @Override
            public void run() {
                System.out.println("子类汽车跑");
            }
        };
        car.run();

//        参数式匿名内部类
        test02(new Car(){
            @Override
            public void run() {
                System.out.println("参数式匿名内部类，汽车跑");

            }
        });
    }


}

class Car{

    public void run(){

        System.out.println("小车跑");
    }
}

