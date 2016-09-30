package ao.shang.cai.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("尚澳", new Wife("高圆圆"));
        map.put("张三", new Wife("李四"));
        map.remove("尚澳");
        Wife w = (Wife) map.get("尚澳");
        map.containsKey("张三");
        System.out.println(w.name);
    }


}
class Wife{
    String name;

    public Wife(String name) {
        this.name = name;
    }
}