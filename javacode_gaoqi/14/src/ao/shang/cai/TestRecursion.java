package ao.shang.cai;

/**
 * 递归测试
 * Created by 蔡尚澳 on 2016/7/3.
 */
public class TestRecursion {
    static int a=0;
    public static void test01(){
        a++;
        System.out.println("test:"+a);
        if (a<=10){ //递归头
            test01();
        }else { //递归体
            System.out.println("over");
        }
    }

    public static long factorial(int a){
        if (a==1){
            return 1;
        }else {
            return a*factorial(a-1);
        }
    }

    public static void main(String[] args) {
        test01();
        System.out.println(factorial(5));
    }
}
