package ao.shang.cai.array2;

/**
 * Created by 蔡尚澳 on 2016/7/10.
 */
public class Test01 {
    public static void main(String[] args) {
        int[][] a={
                {1,2},
                {4,9,0,5},
                {3,4,6}
        };

        int[][] b = new int[3][];
        b[0] = new int[2];
        b[1] = new int[4];
        b[2] = new int[3];
        b[0][0]=1;
        b[0][1]=2;
        b[1][0]=4;
        b[1][1]=9;
        b[1][2]=0;
        b[1][4]=5;
        b[2][0]=3;
        b[2][1]=4;
        b[2][2]=6;

        System.out.println(b[2][2]);



    }
}
