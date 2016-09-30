package ao.shang.cai.adapter;

/**
 *
 * 适配器      (实际使用了组合的方式)
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class Adapter2 implements Target {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {

       adaptee.request();
    }
}
