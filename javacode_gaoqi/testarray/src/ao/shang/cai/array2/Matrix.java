package ao.shang.cai.array2;

/**
 * 测试矩阵加法并打印
 * Created by 蔡尚澳 on 2016/7/10.
 */
public class Matrix {
    /**
     * 矩阵的加法
     * @param a
     * @param b
     * @return 返回矩阵的结果
     */
    public static int[][] add(int[][] a,int[][] b){
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i < c.length ; i++) {
            for (int j = 0; j <c.length ; j++) {
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }

    /**
     * 打印二维矩阵
     * @param c
     */
    public static void print(int [][] c){
        for (int i = 0; i < c.length ; i++) {
            for (int j = 0; j <c.length ; j++) {
                System.out.print(c[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 5},
                {4, 5, 5},
                {6, 8, 9}
        };
        int[][] b = {
                {1, 2, 5},
                {4, 5, 5},
                {6, 8, 9}
        };
        
        int[][] c=add(a, b);

        print(c);
    }
}
