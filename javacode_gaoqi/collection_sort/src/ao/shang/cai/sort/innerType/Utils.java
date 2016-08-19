package ao.shang.cai.sort.innerType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class Utils {

    //list排序+比较器
    public static <T> void sort(List<T> lists,Comparator<T> com) {
//        转成数组
        Object[] arr = lists.toArray();
        sort( arr,com);
//          改变容器中的值
        for (int i=0;i<arr.length;i++) {
            lists.set(i, (T) arr[i]);
        }
    }



    //数组排序+比较器
    public static <T> void sort(Object[] arr,Comparator<T> com) {
        int len = arr.length;
        boolean sorted = true;
        for (int j = 0; j < len-1; j++) {
            sorted = true;  //假定有序
            for (int i = 0; i < len- 1-j; i++) {

                if (com.compare((T)arr[i],(T) arr[i+1])<0) {
                } else {
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }

            }
            if (sorted) {
                break;
            }
        }
    }


    //容器排序，泛型
    public static <T extends Comparable> void sort(List<T> lists) {
//        转成数组
        Object[] arr = lists.toArray();
        sort(arr);
//          改变容器中的值
        for (int i=0;i<arr.length;i++) {
            lists.set(i, (T) arr[i]);
        }



    }

    //数组排序  泛型
    public static <T extends Comparable> void sort(T[] arr) {
        int len = arr.length;
        boolean sorted = true;
        for (int j = 0; j < len-1; j++) {
            sorted = true;  //假定有序
            for (int i = 0; i < len- 1-j; i++) {

                if (((Comparable)arr[i]).compareTo(arr[i + 1])>0) {
                } else {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }

            }
            if (sorted) {
                break;
            }
        }
    }




    //按从大到小排序
    public static void sort(Object[] arr) {
        int len = arr.length;
        boolean sorted = true;
        for (int j = 0; j < len-1; j++) {
            sorted = true;  //假定有序
            for (int i = 0; i < len- 1-j; i++) {

                if (((Comparable)arr[i]).compareTo(arr[i + 1])>0) {
                } else {
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }

            }
            if (sorted) {
                break;
            }
        }
    }

}
