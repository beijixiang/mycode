package ao.shang.cai.sort.three;

import java.util.EnumMap;

/**
 * Created by 蔡尚澳 on 2016/7/23.
 */
public class EnumMapDemo {
    public static void main(String[] args) {

        EnumMap<Season, String> map = new EnumMap<Season, String>(Season.class);
//        存放值
        map.put(Season.SPRING, "cun");
        map.put(Season.SUMMER, "xia");
        map.put(Season.FALL, "qiu");
        map.put(Season.WINTER, "dong");
//
        System.out.println(map.size());
    }
}

enum Season {
    SPRING,SUMMER,FALL, WINTER
}
