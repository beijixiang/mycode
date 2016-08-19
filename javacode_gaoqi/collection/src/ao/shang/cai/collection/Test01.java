package ao.shang.cai.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/7/16.
 */
public class Test01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add(new Date());
        list.add(new dog());
        list.add(1,1234);
        list.set(2, "sss");
        System.out.println(list.size());
        System.out.println(list.isEmpty());

//

        List list2 = new ArrayList();
        list2.add("bbb");
        list2.add("ccc");
        list.add(list2);
        System.out.println(list.size());

        String str = (String) list.get(0);
        System.out.println(str);
        list.set(1, "ababa");
        list.remove(0);



    }
}

class dog{

}
