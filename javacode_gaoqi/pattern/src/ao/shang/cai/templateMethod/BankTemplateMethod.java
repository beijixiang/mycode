package ao.shang.cai.templateMethod;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public abstract class BankTemplateMethod {
//    具体方法
    public void takeNumber(){
        System.out.println("取号排队");

    }

    public abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");

    }

    public final void process(){
        this.takeNumber();
        this.transact();
        this.evaluate();
    }

}
