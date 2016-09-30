package ao.shang.cai.test;

import ao.shang.cai.test.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态操作构造器，属性，方法
 * Created by 蔡尚澳 on 2016/8/6.
 */
public class Demo3 {
    public static void main(String[] args) {
        String path = "ao.shang.cai.test.bean.User";

        try {
            Class<User> clazz = (Class<User>) Class.forName(path);

//            动态调用构造方法
            User u = clazz.newInstance();   // 其实调用了无参构造
            System.out.println(u);
//          带参构造的调用
            Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            User u2 = c.newInstance(100, 20, "尚澳二");
            System.out.println(u2.getUname());
//          通过反射API调用普通方法
            User u3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3, "尚澳三");
            System.out.println(u3.getUname());

//            通过反射API调用属性
            User u4 = clazz.newInstance();
            Field field = clazz.getDeclaredField("uname");
            field.setAccessible(true);  //通知不用再做安全检查
            field.set(u4, "尚澳四");
            System.out.println(u4.getUname());
            System.out.println(field.get(u4));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
