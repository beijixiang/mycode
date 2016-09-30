package ao.shang.cai.sort.col;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class TreeMapDemo2 {
    public static void main(String[] args) {
        Worker w1 = new Worker("垃圾回收员", 12000);
        Worker w2 = new Worker("业务员", 8000);
        Worker w3 = new Worker("程序员", 5000);

        TreeMap<Worker,String> emploees = new TreeMap<>();
        emploees.put(w1,"hehe");
        emploees.put(w2,"hehe");
        emploees.put(w3,"hehe");

        System.out.println(emploees.keySet());
    }
}
