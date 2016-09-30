package ao.shang.cai.commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 双向map
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo07 {
    public static void main(String[] args) {
//        hashMap();
        treeMap();
    }

    /*
   * 有序map
   *
   */
    public static void treeMap(){
        BidiMap<String, String> map = new DualTreeBidiMap<>();
        map.put("b", "b@qq.com");
        map.put("v", "v@qq.com");
        map.put("d", "d@qq.com");
        map.put("a", "a@qq.com");



        MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
//        循环遍历
        while (it.hasNext()) {
            String key = it.next();
            String value = it.getValue();
            System.out.println(key + "---->" + value);
        }

    }

    /*
    * 无序map
    *
    */
    public static void hashMap(){
        BidiMap<String, String> map = new DualHashBidiMap<>();
        map.put("a", "a@qq.com");
        map.put("b", "b@qq.com");
        map.put("v", "v@qq.com");
        map.put("d", "d@qq.com");

        System.out.println(map.inverseBidiMap().get("v@qq.com"));

        MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
//        循环遍历
        while (it.hasNext()) {
            String key = it.next();
            String value = it.getValue();
            System.out.println(key + "---->" + value);
        }

    }
}
