package ao.shang.cai;

/**
 * Created by 蔡尚澳 on 2016/7/2.
 */
public class TestForWhile02 {
    public static void main(String[] args) {
        for(int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.printf(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
