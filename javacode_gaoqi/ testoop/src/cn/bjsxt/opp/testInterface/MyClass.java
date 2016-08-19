package cn.bjsxt.opp.testInterface;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class MyClass implements MyInterface {

    @Override
    public void test01() {
        System.out.println("test01");
    }

    @Override
    public int test02(int a, int b) {

        System.out.println("test02");
        return a+b;
    }
}
