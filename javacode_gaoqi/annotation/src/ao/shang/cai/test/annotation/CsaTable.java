package ao.shang.cai.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 蔡尚澳 on 2016/8/5.
 */


@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CsaTable {
    String value();
}
