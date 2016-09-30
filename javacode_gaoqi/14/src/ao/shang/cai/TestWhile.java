package ao.shang.cai;

/**
 * Created by 蔡尚澳 on 2016/5/9.
 * 测试while虚幻语句
 */
public class TestWhile {
    public static void main(String[] args) {
        int a = 1;  //初始化

        while (a <= 100) {  //条件判断
            System.out.println(a);  //循环体
            a++;    //迭代
        }
        System.out.println("while循环语句结束");

        //计算1+2+3+。。。。。。+100
        int b=1;
        int sum=0;
        while (b<=100){
            sum+=b;
            b++;
        }
        System.out.println("何为："+sum);
    }
}
