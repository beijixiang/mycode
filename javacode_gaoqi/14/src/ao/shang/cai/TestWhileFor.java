package ao.shang.cai;

/**
 * Created by 蔡尚澳 on 2016/5/9.
 * while和for循环测试
 */
public class TestWhileFor {
    public static void main(String[] args) {
        int oddsum=0; //涌来保存奇数的和
        int evensum=0;  //用来保存偶数的和
        for(int i=0;i<=100;i++){
            if (i%2!=0){
                oddsum+=i;
            }else {
                evensum+=i;
            }
        }
        System.out.println("奇数和为"+oddsum);
        System.out.println("偶数和为"+evensum);

        int line=0;
        for(int j=1;j<=1000;j++){
            if(j%5==0){
                System.out.print(j+"\t");
                line++;
                if(line%3==0){
                    System.out.println();
                }

            }
        }



    }
}
