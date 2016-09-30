package ao.shang.cai.test;

/**
 * 测试包装类的基本用法
 * Created by 蔡尚澳 on 2016/7/11.
 */
public class Test01 {
    public static void main(String[] args) {
        Integer a = new Integer(1000);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toHexString(a));
        Integer i2 = Integer.parseInt("234");
        System.out.println(i2);
        Integer i3 = new Integer("234");
        System.out.println(i2.intValue());

        String str = 123 + "";

    }
}
