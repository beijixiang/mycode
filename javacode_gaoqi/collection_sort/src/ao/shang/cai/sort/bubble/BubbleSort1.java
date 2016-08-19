package ao.shang.cai.sort.bubble;

import java.util.Arrays;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5};
        sort(arr);
    }

    //第一个版本很简单
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int j = 0; j < len-1; j++) {
            System.out.println("第"+(j+1)+"趟");
            for (int i = 0; i < len- 1; i++) {
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

    public static void secondSort(int[] arr) {
        FirstSort(arr);
        System.out.println("第二趟");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print("第" + (i + 1) + "次");
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void FirstSort(int[] arr){
        System.out.println("第一趟");
        for (int i=0;i<arr.length-1;i++) {
            System.out.print("第"+(i+1)+"次");
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }


        /*System.out.println("第一趟");
        int i = 0;
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("第二趟");
        i = 1;
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("第三趟");
        i = 2;
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("第四趟");
        i = 3;
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));*/
    }

}
