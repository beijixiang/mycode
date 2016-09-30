package ao.shang.cai.collection2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class Test02 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name", "高琪");
        map.put("id", 0301);
        map.put("department", "项目部");
        map.put("salary", 3000);
        map.put("heriDate", "2007-06");

        Map map2 = new HashMap();
        map2.put("name", "马士兵");
        map2.put("id", 0302);
        map2.put("department", "教学部");
        map2.put("salary", 3500);
        map2.put("heriDate", "2006-06");

        Map map3 = new HashMap();
        map3.put("name", "高琪");
        map3.put("id", 0303);
        map3.put("department", "教学部");
        map3.put("salary", 3550);
        map3.put("heriDate", "2007-05");


        ArrayList<Map> list = new ArrayList<Map>();
        list.add(map);
        list.add(map2);
        list.add(map3);

        printEmpName(list);


    }

    public static void printEmpName(ArrayList<Map> list) {
        for (int i = 0; i < list.size(); i++) {
            Map tempMap=list.get(i);
            System.out.println(tempMap.get("name")+"--"+tempMap.get("salary"));
        }
    }


}
