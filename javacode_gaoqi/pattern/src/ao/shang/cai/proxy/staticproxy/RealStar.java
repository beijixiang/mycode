package ao.shang.cai.proxy.staticproxy;

/**
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class RealStar implements Start {

    @Override
    public void Confer() {
        System.out.println("RealStar.Confer");
    }

    @Override
    public void signConstract() {
        System.out.println("RealStar.signConstract");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("RealStar(周杰伦本人).sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney");
    }
}
