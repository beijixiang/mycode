package ao.shang.cai.commons;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 迭代器
 * Map迭代器
 * <p>
 * Created by 蔡尚澳 on 2016/7/26.
 */
public class Demo06 {
    public static void main(String[] args) {
//        mapit();
//        uniqueIt();/**/
//        filterIt();
//        loopIt();
            arrayIt();
    }

    /*
    * 数组迭代器
    *
    * */

    public static void arrayIt(){
        System.out.println("==========数组迭代器=========");
        int[] arr = {1, 2, 3, 4, 5, 6};
//        迭代器
        Iterator<Integer> it = new ArrayListIterator<Integer>(arr,1,4);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    /*
    * 循环迭代器
    *
    * */
    public static void loopIt(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("v");
        list.add("b");
        list.add("t");
        list.add("s");
        Iterator<String> it = new LoopingIterator<>(list);
        for (int i = 0; i < 15; i++) {
            System.out.println(it.next());
        }


    }


    /*
    * 自定义迭代器
    *
    * */

    public static void filterIt(){
        List<String> list = new ArrayList<>();
        list.add("dad");
        list.add("moom");
        list.add("derg");
        list.add("refer");
//        判断 断言
        Predicate<String> pre=new Predicate<String>() {
            @Override
            public boolean evaluate(String s) {
                return new StringBuilder(s).reverse().toString().equals(s);
            }
        };
        Iterator<String> it = new FilterIterator(list.iterator(), pre);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    /*
    * 去重迭代器
    *
    * */
    public static void uniqueIt() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("v");
        list.add("a");

        Iterator<String> it = new UniqueFilterIterator(list.iterator());
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

/*
* map迭代器
*
* */

    public static void mapit() {
        IterableMap<String, String> map = new HashedMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("v", "v");
        map.put("e", "e");

        MapIterator<String, String> mapit = map.mapIterator();
        while (mapit.hasNext()) {
            String key = mapit.next();
            String value = mapit.getValue();
            System.out.println(key + "--->" + value);
        }


    }
}
