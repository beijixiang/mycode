package ao.shang.cai.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class TestEquals {
    public static void main(String[] args) {
        List list = new ArrayList();
        String str1 = new String("aaa");
        String str2 = new String("aaa");
        list.add(str1);
        list.add(str2);
        System.out.println(list.size());

        Map map = new HashMap();
        map.put(str1, "AAAA");
        map.put(str2, "BBBB");
        System.out.println(map.get("aaa"));



    }
}
