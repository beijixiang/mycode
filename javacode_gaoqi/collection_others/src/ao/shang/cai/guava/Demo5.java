package ao.shang.cai.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Set;


/**
 * 计算单词出现的次数
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Demo5 {
    public static void main(String[] args) {

        String str = "this is a cat and that is a mice where is a food";
//        分割字符串
        String[] strArray = str.split(" ");
//        存储容器
        Multiset<String> set = HashMultiset.create();
        for (String temp : strArray) {
            set.add(temp);
        }
//        遍历容器
        Set<String> set1 = set.elementSet();
        System.out.println(set1);

        for (String temp : set1) {
            System.out.println(temp+"---->"+set.count(temp));
        }
    }
}
