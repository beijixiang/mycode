package ao.shang.cai.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 * 使用反射读取注解信息，模拟处理注解流程信息
 * Created by 蔡尚澳 on 2016/8/5.
 */

public class Demo03 {

    public static void main(String[] args) {
        try {
//            获取类所以注解信息
            Class clazz = Class.forName("ao.shang.cai.test.annotation.CsaStudent");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation temp : annotations) {
                System.out.println(temp);

            }
//            获取指定类的注解信息
            CsaTable ct = (CsaTable) clazz.getAnnotation(CsaTable.class);
            System.out.println(ct.value());

            Field f = clazz.getDeclaredField("studentName");

            CsaField csaField = f.getAnnotation(CsaField.class);
            System.out.println(csaField.columnName() + "---" + csaField.type() + "----" + csaField.length());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
