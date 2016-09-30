package ao.shang.cai.factory.simpleFactory;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class CarFactory2 {

    public static Car creatAudi(){
        return new Audi();
    }

    public static Car creatByd(){
        return new Byd();
    }

}
