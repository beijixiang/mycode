package ao.shang.cai.sort.synread;

import java.util.*;


/**
 * 只读设置
 * Created by 蔡尚澳 on 2016/7/23.
 */
public class Demo2 {
    public static void main(String[] args) {

//        不可变容器
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
//        只读设置
        Map<String, String> map2 = Collections.unmodifiableMap(map);
//        map2.put("c", "c");   //不可变容器
        System.out.println(map.size());

//        一个元素容器设置
        List<String> list = Collections.singletonList(new String());
//        list.add("a");
//        list.add("b");    //不能存放第二个
        System.out.println(list.size());
    }

//
    public static Set<String> ope(Set set) {
        if (set != null) {
            return Collections.emptySet();//避免空指针异常
        }
        return set;
    }
}
