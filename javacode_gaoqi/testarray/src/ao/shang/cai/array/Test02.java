package ao.shang.cai.array;

import java.io.CharArrayReader;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class Test02 {
    public static void main(String[] args) {
        //声明
        int[] a;
        int b[];
        //创建数组对象
        a = new int[4];
        b = new int[5];

        //初始化
        //默认初始化，数组元素相当于成员变量，初始化规则一样，数字0，布尔false，char\u0000,引用null
        //动态初始化

        for (int i = 0; i < a.length; i++) {
            a[i]=i*12;
        }

        //静态初始化
        int c[] = {34, 65, 65, 44};
        Car[] cars={new Car("奔驰"),new Car("宝马"),new Car("比亚迪")};
        Car car2 = new Car("奔驰");
        System.out.println(cars[0]==car2);
    }
}
