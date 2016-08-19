package ao.shang.cai.sort.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试Collections常用方法
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class CollectionsDemo01 {
    public static void main(String[] args) {
        testreverse();
        List<Integer> list = new ArrayList<>();
//        模拟洗牌
        for (int i = 0; i < 54; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2= new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        for (int j = 0; j < 51; j+=3) {
            p1.add(list.get(j));
            p2.add(list.get(j+1));
            p3.add(list.get(j+2));
        }
        last.add(list.get(51));
        last.add(list.get(52));
        last.add(list.get(53));
        System.out.println("第一个人牌："+p1);
        System.out.println("第二个人牌："+p2);
        System.out.println("第三个人牌："+p3);
        System.out.println("底牌："+last);

    }

    public static void testreverse(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.toString());
//        容器内元素反转
        Collections.reverse(list);
        System.out.println(list.toString());
    }
}
