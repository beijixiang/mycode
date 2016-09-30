package ao.shang.cai.sort.innerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * collections 对容器的比较
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class Demo5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("def");
        list.add("a");
        list.add("abcd");
        list.add("abc");
        Collections.sort(list,new StringComp());
        System.out.println(list);


        list = new ArrayList<String>();
        list.add("def");
        list.add("a");
        list.add("abcd");
        list.add("abc");
        Collections.sort(list);
        System.out.println(list);
    }
}
