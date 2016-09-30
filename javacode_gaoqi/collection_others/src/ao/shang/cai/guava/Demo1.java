package ao.shang.cai.guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 只读设置
 * Created by 蔡尚澳 on 2016/7/24.
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        相当于拍了一个快照
        List<String> list2 = Collections.unmodifiableList(list);
//        list2.add("d");
        list.add("d");

//        guava只读设置
        List<String> immutableList = ImmutableList.of("a", "b", "c", "d");
        immutableList.add("e");
    }
}
