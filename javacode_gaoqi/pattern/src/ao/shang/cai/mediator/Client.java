package ao.shang.cai.mediator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new President();

        Department marlket = new Market(mediator);
        Department finacial = new finacial(mediator);
        Department development = new Development(mediator);

        marlket.selfAction();
        marlket.outAction();
    }
}
