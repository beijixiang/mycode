package ao.shang.cai.collection;

import java.util.HashMap;

/**
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class MyHashSet {
    HashMap map;
    private static final Object PRESENT = new Object();


    public MyHashSet(){
        map = new HashMap();
    }

    public int size(){
        return map.size();
    }

    public void add(Object o) {
        map.put(o, PRESENT);
    }

    public void remove(){

    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add("aaa");
        set.add(new String("aaa"));
        System.out.println(set.size());

    }
}
