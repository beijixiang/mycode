package ao.shang.cai.sort.col;

import java.util.TreeSet;

/**
 *
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        Worker w1 = new Worker("垃圾回收员", 12000);
        Worker w2 = new Worker("业务员", 8000);
        Worker w3 = new Worker("程序员", 5000);

        TreeSet<Worker> emploees = new TreeSet<>();
        emploees.add(w1);
        emploees.add(w2);
        emploees.add(w3);
        System.out.println(emploees);
    }
}
