package ao.shang.cai.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 蔡尚澳 on 2016/8/5.
 */
@Target(value = {ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface CsaAnnotation01 {

    String studentName() default "";
    int age() default 0;
    int id() default 0;

    String[] schools() default {"清华大学","北京大学"};


}
