package ao.shang.cai.sort.innerType;

import java.util.Arrays;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class Demo2 {
    public static void main(String[] args) {
        String[] arrs = { "def", "a", "abcd","abc"};
        sortFinal(arrs);

    }

    //按从大到小排序
    public static void sortFinal(String[] arr) {
        int len = arr.length;
        boolean sorted = true;
        for (int j = 0; j < len-1; j++) {
            sorted = true;  //假定有序
            for (int i = 0; i < len- 1-j; i++) {

                if (((Comparable)arr[i]).compareTo(arr[i + 1])>0) {
                } else {
                    String temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }

            }
            if (sorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
