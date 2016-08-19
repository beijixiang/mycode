package ao.shang.cai.mediator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Development implements Department {

//    持有中介者对象
    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("devolopment", this);

    }

    @Override
    public void selfAction() {
        System.out.println("科研研发研发");
    }

    @Override
    public void outAction() {

        System.out.println("汇报工作，没钱了，请求资金");

    }
}
