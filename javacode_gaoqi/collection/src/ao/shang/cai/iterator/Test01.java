package ao.shang.cai.iterator;

import java.util.*;

/**
 * 测试迭代器
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class Test01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //通过索引实现遍历list
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            System.out.println(str);
        }
        //通过迭代器遍历list
        for (Iterator iter = list.iterator();iter.hasNext();){
            String str = (String) iter.next();
            System.out.println(str);

        }

        //通过迭代器遍历set

        Set set = new HashSet();
        set.add("gao1");
        set.add("gao2");
        set.add("gao3");

//        Iterator iter = set.iterator();
//        while (iter.hasNext()) {
        for (Iterator iter = set.iterator();iter.hasNext();){
            String str = (String) iter.next();
            System.out.println(str);

        }
    }
}
