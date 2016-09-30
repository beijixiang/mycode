package ao.shang.cai.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**函数式编程
 * 1、predictate
 * 2、function
 *
 *
 * Created by 蔡尚澳 on 2016/7/24.
 */
public class Demo2 {
    public static void main(String[] args) {
//      组合式函数编程
//        确保容器中的字符串长度不超过5，超过截取，然后全部转为大写
        List<String> list = Lists.newArrayList("addd", "bdd", "cddd", "ddddddddd");

        Function<String,String> f1=new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.length()>5?s.substring(0,5):s;
            }
        };

//        转换成大写
        Function<String,String> f2=new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
//        函数组合
        Function<String, String> function = Functions.compose(f1, f2);
        Collection<String> collection = Collections2.transform(list, function);
        for (String temp : collection) {
            System.out.println(temp);
        }

    }

    public static void test2(){
        //        类型转换
        Set<Long> times= Sets.newHashSet();
        times.add(1000000000L);
        times.add(1000000000000000L);
        times.add(2000000000L);


        Collection<String> list=Collections2.transform(times, new Function<Long, String>() {
            @Override
            public String apply(Long aLong) {
                return new SimpleDateFormat("yy-MM-dd").format(aLong);
            }
        });

        for (String temp : list) {
            System.out.println(temp);
        }
    }
    /*
    *过滤器
    *
    */
    public static void test(){
        //        创建静态化初始
        List<String> list = Lists.newArrayList("a", "b", "c", "d");
//      找出回文
        Collection<String> palindrome= Collections2.filter(list,new Predicate<String>(){

            @Override
            public boolean apply(String s) {
//                业务逻辑
                return new StringBuilder(s).reverse().toString().equals(s);
            }
        } );

        for (String temp : palindrome) {
            System.out.println(temp);
        }

    }
}
