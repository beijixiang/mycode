package ao.shang.cai.mediator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class finacial implements Department {

//    持有中介者对象
    private Mediator mediator;

    public finacial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("finacial", this);

    }

    @Override
    public void selfAction() {
        System.out.println("数钱");

    }

    @Override
    public void outAction() {

        System.out.println("汇报工作，钱太多了");

    }
}
