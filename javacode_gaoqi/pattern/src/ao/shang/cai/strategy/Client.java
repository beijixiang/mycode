package ao.shang.cai.strategy;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Client {
    public static void main(String[] args) {
        Strategy s1 = new OldCustomerFewStrategy();
        Context context = new Context(s1);
        context.printPrice(988);

    }
}
