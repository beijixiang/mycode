package ao.shang.cai.propotype;

import java.io.*;
import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client3 {
    public static void main(String[] args) throws Exception{
        Date date = new Date(312342342342L);
        Sheep s1 = new Sheep("少利", date);

//        Sheep2 s2 = (Sheep2) s1.clone();

//        采用序列化和反序列化的方式进行深复制
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(s1);
        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Sheep s2 = (Sheep) ois.readObject();


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
