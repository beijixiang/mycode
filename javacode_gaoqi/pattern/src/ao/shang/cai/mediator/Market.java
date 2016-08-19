package ao.shang.cai.mediator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Market implements Department {

//    持有中介者对象
    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market", this);

    }

    @Override
    public void selfAction() {
        System.out.println("跑业务");

    }

    @Override
    public void outAction() {

        System.out.println("汇报工作，没钱了，请求资金");
        mediator.command("finacial");

    }
}
