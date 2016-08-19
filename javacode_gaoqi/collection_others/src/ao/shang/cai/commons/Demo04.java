package ao.shang.cai.commons;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 交集
 * 并集
 * 差集
 * Created by 蔡尚澳 on 2016/7/26.
 */
public class Demo04 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

//        并集
        System.out.println("=========并集============");
        Collection<Integer> collection = CollectionUtils.union(set1, set2);
        for (Integer temp : collection) {
            System.out.println(temp);
        }

        //        交集
        System.out.println("=========交集============");
        Collection<Integer> collection2 = CollectionUtils.intersection(set1, set2);
        for (Integer temp : collection2) {
            System.out.println(temp);
        }
        //        差集
        System.out.println("=========差集============");
        Collection<Integer> collection3 = CollectionUtils.subtract(set1, set2);
        for (Integer temp : collection3) {
            System.out.println(temp);
        }
    }
}
