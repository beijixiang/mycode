package ao.shang.cai.array;

/**
 * 测试数组的基本使用
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class Test01 {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0]=32;
        a[1]=45;
        a[2]=32;

        Car[] cars = new Car[4];
        cars[0] = new Car("奔驰");
        System.out.println(cars[0].name);


        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }
}
