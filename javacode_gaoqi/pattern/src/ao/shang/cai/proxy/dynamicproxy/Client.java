package ao.shang.cai.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class Client {

    public static void main(String[] args) {
        Start realStart = new RealStar();
        StartHandler handler = new StartHandler(realStart);

        Start proxy = (Start) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Start.class}, handler);


        proxy.sing();
    }
}
