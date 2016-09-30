package ao.shang.cai.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;
import java.util.Map;

/**
 * dimap 双向Map 值都不可以重复
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Demo7 {
    public static void main(String[] args) {
        BiMap<String, String> map = HashBiMap.create();
        map.put("dddd", "dddd@qq.com");
        map.put("eeee", "eeee@sina.com");
        //        通过value找key
        String user=map.inverse().get("eeee@sina.com");
        System.out.println(user);

        System.out.println(map.inverse().inverse()==map);

    }
}
