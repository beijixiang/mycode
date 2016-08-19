package ao.shang.cai.commons;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

import java.util.Iterator;
import java.util.Set;

/**
 * 包
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo08 {
    public static void main(String[] args) {
//        hashBag();
//        treeBag();

        String str = "this is a cat and that is a mice where is a food";
//        分割字符串
        String[] strArray = str.split(" ");

        Bag<String> bag = new TreeBag<>();
        for (String temp : strArray) {
            bag.add(temp);
        }
        System.out.println("=======统计次数========");

        Set<String> keys = bag.uniqueSet();
        for (String temp : keys) {
            System.out.println(temp + "----->" + bag.getCount(temp));
        }



    }

    /*
    *
    *无序的包
    */
    public static void treeBag(){
        System.out.println("===========有序包========");
        Bag<String> bag = new TreeBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("a", 5);
        Iterator<String> it = bag.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }

    /*
    *
    *无序的包
    */
    public static void hashBag(){
        System.out.println("===========无序包========");
        Bag<String> bag = new HashBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("a", 5);
        Iterator<String> it = bag.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }
}
