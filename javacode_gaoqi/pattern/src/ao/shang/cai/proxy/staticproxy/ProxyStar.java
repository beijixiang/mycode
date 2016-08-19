package ao.shang.cai.proxy.staticproxy;

/**
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class ProxyStar implements Start {

    private RealStar realStar;

    public ProxyStar(RealStar realStar) {
        this.realStar = realStar;
    }

    @Override
    public void Confer() {
        System.out.println("ProxyStar.Confer");
    }

    @Override
    public void signConstract() {
        System.out.println("ProxyStar.signConstract");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket");
    }

    @Override
    public void sing() {
        realStar.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney");
    }
}
