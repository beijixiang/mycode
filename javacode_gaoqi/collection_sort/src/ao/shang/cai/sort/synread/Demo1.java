package ao.shang.cai.sort.synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 容器线程同步
 * Created by 蔡尚澳 on 2016/7/23.
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        Collections.synchronizedList(list);
        System.out.println("线程同步完毕");
    }
}
