package ao.shang.cai.sort.innerType;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class Demo3 {
    public static void main(String[] args) {
        Date[] arrs = new Date[3];
        arrs[0] = new Date();
        arrs[1] = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        arrs[2] = new Date(System.currentTimeMillis() - 1000 * 60 * 60);

        sortFinal(arrs);

    }

    //按从大到小排序
    public static void sortFinal(Date[] arr) {
        int len = arr.length;
        boolean sorted = true;
        for (int j = 0; j < len-1; j++) {
            sorted = true;  //假定有序
            for (int i = 0; i < len- 1-j; i++) {

                if (((Comparable)arr[i]).compareTo(arr[i + 1])>0) {
                } else {
                    Date temp = arr[i];
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
