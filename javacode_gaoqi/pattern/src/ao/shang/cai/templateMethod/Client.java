package ao.shang.cai.templateMethod;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Client {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        BankTemplateMethod btm1 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱");
            }
        };
        btm1.process();
    }
}

class DrawMoney extends BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("我要取钱");
    }
}
