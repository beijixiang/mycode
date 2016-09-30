package ao.shang.cai.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 函数式编程
 * predicate 断言
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("===========自定义判断============");
        Predicate<String> selfPre=new Predicate<String>() {
            @Override
            public boolean evaluate(String s) {
                return s.length() >= 5 && s.length() <= 20;
            }

        };
        Predicate<String> pre = NotNullPredicate.notNullPredicate();

        Predicate all = PredicateUtils.allPredicate(selfPre, pre);
        List<String> list = PredicatedList.predicatedList(new ArrayList(), all);
        list.add("eeeee");
//        list.add(null);
//        list.add("sss");


    }

    /**
     * 唯一判断
     */
    public static void unique(){
        System.out.println("============唯一判断=========");
        Predicate<String> unique = UniquePredicate.uniquePredicate();
        List<Long> list = PredicatedList.predicatedList(new ArrayList(), unique);
        list.add(1000L);
        list.add(2000L);
//        list.add(1000L);  验证失败
    }

    /**
     * 非空判断
     */
    public static void notNull(){
        System.out.println("===========非空判断============");
        Predicate<String> pre = NotNullPredicate.notNullPredicate();
        System.out.println(pre.evaluate(null));//如果为空则返回false

//        添加容器值判断
        List<String> list = PredicatedList.predicatedList(new ArrayList<>(), pre);
        list.add("aaa");
//        list.add(null);

    }

    /**
     * 相等判断
     */
    public static void equals(){
        System.out.println("===========相等判断============");
        Predicate<String> pre = EqualPredicate.equalPredicate("hehe");
        boolean equal = pre.evaluate("heheh");
        System.out.println(equal);
    }
}
