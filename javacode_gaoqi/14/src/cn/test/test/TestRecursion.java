package cn.test.test;

/**
 *这是用来测试递归的，含有一个乘数递归方法
 * @author 蔡尚澳
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

    /**
     * 这是乘数递归
     * @param a 表示乘数最大的数
     * @return  返回乘数的结果
     */

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
