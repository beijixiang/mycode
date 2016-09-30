package ao.shang.cai.factory.abstractFactory;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryCarFactory();
        Engine engine = factory.CreatEngine();
        engine.run();
        engine.start();

    }
}
