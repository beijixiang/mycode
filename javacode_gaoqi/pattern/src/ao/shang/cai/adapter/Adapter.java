package ao.shang.cai.adapter;

/**
 *
 * 适配器 （实际使用了继承的方式）
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void handleRequest() {
        super.request();
    }
}
