package ao.shang.cai.sort.bubble;

import java.util.Arrays;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class BubbleSort2 {
    public static void main(String[] args) {
            int[] arr = {9, 8, 7, 6, 5};
            sort(arr);
    }
        //第二个版本，减少次数
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int j = 0; j < len-1; j++) {
            System.out.println("第"+(j+1)+"趟");
            for (int i = 0; i < len- 1-j; i++) {    //减少次数
                System.out.print("第" + (i + 1) + "次");
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
