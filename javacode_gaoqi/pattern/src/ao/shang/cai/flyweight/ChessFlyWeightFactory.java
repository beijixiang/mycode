package ao.shang.cai.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class ChessFlyWeightFactory {

    private static Map<String, ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color){

        if (map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color, cfw);
            return cfw;
        }
    }


}
