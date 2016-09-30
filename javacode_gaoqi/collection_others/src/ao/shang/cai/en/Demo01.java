package ao.shang.cai.en;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo01 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("javase");
        vector.add("orcal");
        vector.add("C++");

        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }
}
