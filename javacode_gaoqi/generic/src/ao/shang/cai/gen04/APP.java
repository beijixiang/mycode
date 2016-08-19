package ao.shang.cai.gen04;

/**
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class APP {
    public static void main(String[] args) {
//        A<Fruit> f = new A<Apple>();
        A<Fruit> f = new A<Fruit>();
//        test(A < Apple >);
    }


    //形参使用多态
    public static void test(A<Fruit> f) {

    }

    public static Fruit test01() {
//        return (A<Fruit>) (new A<Apple>());
        return null;
    }
}
