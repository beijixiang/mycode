package ao.shang.cai;

/**
 * Created by 蔡尚澳 on 2016/5/9.
 * 测试for 循环
 */
public class TestFor {
    public static void main(String[] args) {

        int a = 1;  //初始化

        while (a <= 100) {  //条件判断
            System.out.println(a);  //循环体
            a++;    //迭代
        }
        System.out.println("while循环语句结束");
        for (int i=1;i<=100;i+=2){   //条件判断 初始化 迭代
            System.out.println(i);  //循环体
        }
        System.out.println("for循环结束");
    }
}
