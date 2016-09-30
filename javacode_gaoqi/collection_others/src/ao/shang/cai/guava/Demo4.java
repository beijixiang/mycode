package ao.shang.cai.guava;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import java.util.Set;

/**
 * 集合的交集并集差集
 * Created by 蔡尚澳 on 2016/7/24.
 */
public class Demo4 {
    public static void main(String[] args) {

        Set<Integer> set = Sets.newHashSet(1, 2, 3, 4, 5, 6);
        Set<Integer> set1 = Sets.newHashSet(3, 4, 5, 6, 7, 8, 9);
//    交集
        System.out.println("交集为：");
        SetView<Integer> intersection = Sets.intersection(set, set1);
        for (int temp : intersection) {
            System.out.println(temp);
        }
//    差集
        System.out.println("差集为：");
        SetView<Integer> diff = Sets.difference(set, set1);
        for (int temp : diff) {
            System.out.println(temp);
        }

        //   并集
        System.out.println("差集为：");
        SetView<Integer> union = Sets.union(set, set1);
        for (int temp : union) {
            System.out.println(temp);
        }

    }
}
