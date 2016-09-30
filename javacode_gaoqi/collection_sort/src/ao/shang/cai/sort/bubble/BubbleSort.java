package ao.shang.cai.sort.bubble;

import java.util.Arrays;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 2, 3, 4};
        sort(arr);
        System.out.println("=========final==============");
        int[] arr2=new int[]{9, 1, 2, 3, 4};
        sortFinal(arr2);

    }

    //最终版，考虑已经有序的情况
    public static void sortFinal(int[] arr) {
        int len = arr.length;
        boolean sorted = true;
        for (int j = 0; j < len-1; j++) {
            System.out.println("第"+(j+1)+"趟");
            sorted = true;  //假定有序
            for (int i = 0; i < len- 1-j; i++) {

                System.out.print("第" + (i + 1) + "次");
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
                System.out.println(Arrays.toString(arr));
            }
            if (sorted) {
                break;

            }
        }
    }



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
