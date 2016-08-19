package ao.shang.cai.bridge;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Client {

    public static void main(String[] args) {

        Computer2 c = new Desktop2(new Lenovo());
        c.sale();
    }
}
