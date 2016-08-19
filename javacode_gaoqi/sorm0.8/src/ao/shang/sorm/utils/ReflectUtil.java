package ao.shang.sorm.utils;

import java.lang.reflect.Method;

/**
 * 封装反射常用的操作
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class ReflectUtil {


    /**
     * 调用Object对象对应的field属性的get方法
     * @param fieldName 属性名
     * @param obj   对象
     * @return
     */
    public static Object invokeGet(String fieldName,Object obj) {

        try {
            Class c = obj.getClass();
            Method m = c.getMethod("get" + StringUtil.firstChar2upperCace(fieldName), null);
            return m.invoke(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void invokeSet(Object obj, String columnName, Object clolumValue) {

        Method m = null;
        try {
            m = obj.getClass().getMethod("set" + StringUtil.firstChar2upperCace(columnName)
                    , clolumValue.getClass());
            m.invoke(obj, clolumValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
