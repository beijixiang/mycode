package ao.shang.cai;

/**
 * 测试break和continue
 * Created by 蔡尚澳 on 2016/7/2.
 */
public class TestBreakContinue {
    public static void main(String[] args) {
        System.out.println("Begin");
        int tatle=0;
        while (true){
            tatle++;
            int i=(int)Math.round(100*Math.random());
            if (i==88){
                break;
            }
        }
        System.out.println("Game over run "+tatle+" times");
        System.out.println("##################################");
        for (int j=0;j<100;j++){
            if (j%3==0){
                continue;
            }
            System.out.println(j);
        }
        System.out.println("########################################");
        int count=0;
        outer:for (int i = 101; i < 150; i++) {
            for (int j = 2; j <i/2 ; j++) {
                if (i%j==0)
                    continue outer;
            }
            System.out.println(i+"  ");
        }
    }
}
