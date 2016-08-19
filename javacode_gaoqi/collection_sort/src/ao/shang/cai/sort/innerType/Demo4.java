package ao.shang.cai.sort.innerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class Demo4 {
    public static void main(String[] args) {
        //字符串
        String[] arrs = { "def", "a", "abcd","abc"};
        Utils.sort(arrs);
        System.out.println(Arrays.toString(arrs));

        Date[] arrs2 = new Date[3];
        arrs2[0] = new Date();
        arrs2[1] = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        arrs2[2] = new Date(System.currentTimeMillis() - 1000 * 60 * 60);
        Utils.sort(arrs2);
        System.out.println(Arrays.toString(arrs2));

        //容器排序
        List<String> list = new ArrayList<String>();
        list.add("def");
        list.add("a");
        list.add("abcd");
        list.add("abc");
        Utils.sort(list);
        System.out.println(list);


//        数组排序加比较器
        String[] arrs3 ={ "def", "a", "abcd","abc"};
        Utils.sort(arrs3,new StringComp());
        System.out.println(Arrays.toString(arrs3));


//      list 加比较器
        list = new ArrayList<String>();
        list.add("def");
        list.add("a");
        list.add("abcd");
        list.add("abc");
        Utils.sort(list,new StringComp());
        System.out.println(list);


    }
}
