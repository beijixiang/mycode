package ao.shang.cai.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 通过反射弧反序列化破解单例模式
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        SingletonDemo6 s1 = SingletonDemo6.getInstance();
        SingletonDemo6 s2 = SingletonDemo6.getInstance();

        System.out.println(s1);
        System.out.println(s2);

//        通过反射破解
/*
        Class<SingletonDemo6> clazz = (Class<SingletonDemo6>) Class.forName("ao.shang.cai.singleton.SingletonDemo6");
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDemo6 s3 = (SingletonDemo6) constructor.newInstance();
        SingletonDemo6 s4 = (SingletonDemo6) constructor.newInstance();

        System.out.println(s3);
        System.out.println(s4);
        */
//        通过反序列化破解单例模式
        FileOutputStream fos = new FileOutputStream("F:/myjava/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.flush();
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:/myjava/a.txt"));
        SingletonDemo6 s3 = (SingletonDemo6) ois.readObject();
        System.out.println(s3);
    }

}
