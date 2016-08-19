package ao.shang.cai.proxy.staticproxy;

/**
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class Client {

    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        ProxyStar proxyStar = new ProxyStar(realStar);

        proxyStar.Confer();
        proxyStar.signConstract();
        proxyStar.bookTicket();
        proxyStar.sing();
        proxyStar.collectMoney();

    }
}
