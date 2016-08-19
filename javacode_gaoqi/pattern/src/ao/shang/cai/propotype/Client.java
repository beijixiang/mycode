package ao.shang.cai.propotype;

import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(312342342342L);
        Sheep s1 = new Sheep("少利", date);

        Sheep s2 = (Sheep) s1.clone();

        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());
        date.setTime(241342342344242L);
        System.out.println(s1.getBirthday());

        s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }


}
