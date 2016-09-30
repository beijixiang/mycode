package ao.shang.cai.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取类的 方法及属性，构造器
 * Created by 蔡尚澳 on 2016/8/6.
 */

@SuppressWarnings("all")
public class Demo2 {
    public static void main(String[] args) {

        String path = "ao.shang.cai.test.bean.User";

        try {
            Class<?> clazz = Class.forName(path);
//            获取类的名字

            System.out.println(clazz.getName());    //包名+类名
            System.out.println(clazz.getSimpleName());  //类名
//            获取属性
//            Field[] fields = clazz.getFields(); //只显示public类型
            Field[] fields = clazz.getDeclaredFields();
            Field field = clazz.getDeclaredField("uname");
            System.out.println(fields.length);
            for (Field temp : fields) {
                System.out.println("属性：" + temp);
            }

//            获取方法
            Method[] methods = clazz.getDeclaredMethods();
            Method method1 = clazz.getDeclaredMethod("getUname", null);
//            如果方法有参数，则必须添加
            Method method2 = clazz.getDeclaredMethod("setUname", String.class);
            for (Method temp : methods) {
                System.out.println("方法" + temp);
            }

//            获取构造器
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor temp : constructors) {
                System.out.println("构造器"+temp);

            }
            Constructor constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            System.out.println(constructor);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
