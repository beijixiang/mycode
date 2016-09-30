package ao.shang.cai.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class TestSet {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("aaa");
        set.add("bbb");
        set.add(new String("aaa"));
        System.out.println(set.size());
        System.out.println(set.contains("aaa"));
        set.remove("aaa");
    }
}
