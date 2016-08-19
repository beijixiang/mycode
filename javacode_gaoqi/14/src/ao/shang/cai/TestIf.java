package ao.shang.cai;

/**
 * Created by 蔡尚澳 on 2016/5/9.
 */
//测试if循环语句
public class TestIf {
    public static void main(String[] args) {
        double d = Math.random();
        int e = 1 + (int) (d * 6);   //[0,4]
        System.out.println(e);

        if (e > 3) {
            System.out.println("大数！");
            System.out.println("大数！！！！");
        } else {
            System.out.println("小数！！");
        }


        System.out.println("测试多选择结构");
        if (e == 6) {
            System.out.println("运气非常好");
        } else if (e == 5) {
            System.out.println("运气不错");
        } else if (e == 4) {
            System.out.println("运气还行吧");
        } else {     //1,2,3
            System.out.println("运气不好");
        }


    }
}
