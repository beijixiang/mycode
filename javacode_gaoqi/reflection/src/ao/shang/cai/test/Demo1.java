package ao.shang.cai.test;

/**
 *
 * 测试获取各种类型的Java.lang.Class对象
 * Created by 蔡尚澳 on 2016/8/6.
 */
public class Demo1 {
    public static void main(String[] args) {

        String path = "ao.shang.cai.test.bean.User";

        try {
            Class<?> clazz = Class.forName(path);
            System.out.println(clazz.hashCode());

            Class clazz2 = Class.forName(path);
            System.out.println(clazz2.hashCode());  //一个类只创造一个对象

            Class strClazz = path.getClass();
            Class strClazz2 = String.class;
            System.out.println(strClazz == strClazz2);  //true 一个类型只加载一次


            int[] arr01 = new int[10];
            int[][] arr02 = new int[30][2];
            int[] arr03 = new int[30];
            double[] arr04 = new double[10];

            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
            System.out.println(arr04.getClass().hashCode());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
