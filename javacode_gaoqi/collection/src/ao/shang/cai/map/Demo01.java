package ao.shang.cai.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * this is a cat and that is a mice and where is the food
 * 统计到Map中
 * key :String
 * value 自定义类型
 *
 * “分拣思路”
 * 1，为所有key创建容器
 * 之后容器存放对应的value
 * 2第一次穿件容器并存放值value
 * 第二次之后直接使用容器存放
 *
 *
 * Created by 蔡尚澳 on 2016/7/20.
 */
public class Demo01 {
    public static void main(String[] args) {
        String str = "this is a cat and that is a mice and where is the food";

        //分割字符串
        String[] strarry = str.split(" ");
        //储存到Map中
        Map<String, Letter> letters = new HashMap<>();
        //      创建所有key的容器

        /*for (String temp : strarry) {
            if (!letters.containsKey(temp)) {
                Letter col = new Letter();
                col.setCount(1);
                letters.put(temp, col);
            } else {
//                第二次之后直接使用容器存放值

                Letter col = letters.get(temp);
                col.setCount(col.getCount() + 1);

            }
        }*/

        for (String temp : strarry) {
            Letter col = null;
            if (null==(col=letters.get(temp))) {
                col = new Letter();
                col.setCount(1);
                letters.put(temp, col);
            } else {
//                第二次之后直接使用容器存放值
                col.setCount(col.getCount() + 1);

            }
        }

        //输出map
        Set<String> keys = letters.keySet();
        for (String key : keys) {
            Letter col = letters.get(key);
            System.out.println("字母" + key + "次数" + col.getCount());

        }
    }

    public void test01(){
        String str = "this is a cat and that is a mice and where is the food";

        //分割字符串
        String[] strarry = str.split(" ");
        //储存到Map中
        Map<String, Letter> letters = new HashMap<>();
        //      创建所有key的容器

        for (String temp : strarry) {
            if (!letters.containsKey(temp)) {
                letters.put(temp, new Letter());
            }
        }
//        之后存放对应的value
        for (String temp : strarry) {
            Letter col = letters.get(temp);
            col.setCount(col.getCount() + 1);

        }
        //输出map
        Set<String> keys = letters.keySet();
        for (String key : keys) {
            Letter col = letters.get(key);
            System.out.println("字母" + key + "次数" + col.getCount());

        }

    }

}
