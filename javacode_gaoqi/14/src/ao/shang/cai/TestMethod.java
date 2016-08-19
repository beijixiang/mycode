package ao.shang.cai;

/**
 * Created by 蔡尚澳 on 2016/7/2.
 */
public class TestMethod {

    public static void test01(int a){
        int oddsum=0; //涌来保存奇数的和
        int evensum=0;  //用来保存偶数的和
        for(int i=0;i<=a;i++){
            if (i%2!=0){
                oddsum+=i;
            }else {
                evensum+=i;
            }
        }
        System.out.println("奇数和为"+oddsum);
        System.out.println("偶数和为"+evensum);
    }

    public static void test02(int a,int b,int c) {
        int line=0;
        for(int j=1;j<=a;j++) {
            if (j % b == 0) {
                System.out.print(j + "\t");
                line++;
                if (line % c == 0) {
                    System.out.println();
                }
            }
        }
    }

    public static int add(int a,int b){
        int sum=a+b;
        if (a == 3) {
            return 0;   //return有两个作用：结束方法。返回值
        }
        return sum;
    }

    public static void main(String[] args) {
        test01(100);
        test02(100,5,5);
        int a = add(3, 5);
        System.out.println(a);
    }

}
