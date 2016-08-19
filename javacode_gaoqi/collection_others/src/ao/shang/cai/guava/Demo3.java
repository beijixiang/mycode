package ao.shang.cai.guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.StringTokenizer;

/**
 * 加入约束条件
 * Created by 蔡尚澳 on 2016/7/24.
 */
public class Demo3 {
    public static void main(String[] args) {
        Set<String> set = Sets.newHashSet();
        Constraint<String> constraints = new Constraint<String>(){
            @Override
            public String checkElement(String element) {
                //验证非空
                Preconditions.checkNotNull(element);
                //验证长度
                Preconditions.checkArgument(element.length() >= 5 && element.length() <= 20);

                return element;
            }
        };
        Set<String> cs = new Constraints.ConstrainedSet(set, constraints);
        cs.add("aaaaa");

        for (String temp : cs) {
            System.out.println(temp);
        }
    }
}
