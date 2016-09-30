package ao.shang.cai.strategy;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double standardPrice) {
        System.out.println("您的报价应该是："+strategy.getPrice(standardPrice));
    }
}
