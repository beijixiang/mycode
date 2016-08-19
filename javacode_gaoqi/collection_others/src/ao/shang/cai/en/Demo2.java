package ao.shang.cai.en;

import java.util.StringTokenizer;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo2 {
    public static void main(String[] args) {
        String emailStr = "shangao@qq.com;shangao@gmail.com;shangao@163.com";
        StringTokenizer st = new StringTokenizer(emailStr, ";");
//        遍历获取
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
    }
}
