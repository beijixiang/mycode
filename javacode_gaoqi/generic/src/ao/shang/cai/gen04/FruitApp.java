package ao.shang.cai.gen04;

/**
 * 多态的两种形式
 * 返回类型时声明，参数类型声明
 *
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class FruitApp {

    public static void main(String[] args) {
        Fruit f = new Apple();
        test(f);
    }
    public static void test(Fruit f) {

    }

    public static Fruit test01() {
        return new Apple();
    }
}
