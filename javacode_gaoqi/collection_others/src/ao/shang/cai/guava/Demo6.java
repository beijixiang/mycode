package ao.shang.cai.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 每个老师教授哪门课程
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Demo6 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("dasd", "dadsa");
        map.put("sdasd", "asda");
        map.put("a", "b");
        map.put("c", "b");
        map.put("d", "b");
        map.put("dasda", "uyity");

//        遍历Map
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//        存放multimap
        Multimap<String, String> teachers = ArrayListMultimap.create();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();

            teachers.put(value, key);
        }
//       查看multimap
        Set<String> keyset = teachers.keySet();
        for (String temp : keyset) {
            System.out.println(temp + "--->" + teachers.get(temp));

        }
    }
}
