package ao.shang.cai.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class StartHandler implements InvocationHandler {

    private Start realStar;

    public StartHandler(Start realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("任务执行前");
        System.out.println("面签，签合同，定机票");

        Object object = null;
        if (method.getName().equals("sing")) {
            object=method.invoke(realStar, args);

        }
        System.out.println("任务执行以后");
        System.out.println("收尾款");
        return object;
    }
}
