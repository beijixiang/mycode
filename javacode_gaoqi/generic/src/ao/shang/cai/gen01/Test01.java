package ao.shang.cai.gen01;

import java.util.Objects;

/**
 * Created by 蔡尚澳 on 2016/7/18.
 */
public class Test01 {
    public static void main(String[] args) {
        Object obj = 80;
        int score = (int) obj;  //自动拆箱
        System.out.println(score);

        Student stu = new Student(80, 90);

        int javaseScore = (Integer) stu.getJavase();
        System.out.println(javaseScore);

        String oracleScore =null;
        if (stu.getOrical() instanceof String) {
            oracleScore = (String) stu.getOrical();
        }
        System.out.println(oracleScore);
    }
}
