package ao.shang.cai.sort.three;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap 只比较键地址是否重叠
 * Created by 蔡尚澳 on 2016/7/23.
 */
public class IdentityHashMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        map.put("a", "a1");
        map.put("a", "a1");
        System.out.println(map.size());
        map.put(new String("a"), "a1");
        map.put(new String("a"), "a1");
        System.out.println(map.size());
    }
}
