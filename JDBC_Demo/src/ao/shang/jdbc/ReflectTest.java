package ao.shang.jdbc;

import ao.shang.jdbc.domain.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by cai on 16-9-26.
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        Class clazz = User.class;
//        clazz = Bean.class;
        Object obj = create(clazz);
        System.out.println(obj);

        invoke1(obj,"showMessage");
        System.out.println("---------------");
        field(clazz);
    }

    static Object create(Class clazz) throws Exception {
        Constructor cons = clazz.getConstructor(String.class);
        Object obj = cons.newInstance("test name");
        return obj;
    }

    static void invoke1(Object obj,String methodName) throws
            InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method[] ms = obj.getClass().getDeclaredMethods();
        ms = obj.getClass().getMethods();
        for (Method m : ms) {
//            System.out.println(m.getName());
            if (methodName.equals(m.getName())) {
                m.invoke(obj, null);
            }
        }
        Method m = obj.getClass().getMethod(methodName, null);
        m.invoke(obj, null);
    }

    public static void field(Class clazz) throws Exception{
        Field[] fs = clazz.getDeclaredFields();
//        fs = clazz.getFields();
        for (Field f : fs) {
            System.out.println(f.getName());
        }
    }

    static void annon(Class clazz){
        Annotation[] as = clazz.getAnnotations();
    }
}
