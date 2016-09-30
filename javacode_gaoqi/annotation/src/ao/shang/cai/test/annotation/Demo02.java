package ao.shang.cai.test.annotation;

/**
 * Created by 蔡尚澳 on 2016/8/5.
 */
public class Demo02 {

    @CsaAnnotation01(id = 1001, studentName = "aaa", age = 18, schools = {"hehe", "嘉庚学院"})
    public static void test01() {

    }

    @CasAnnotation2("aaa")
    public static void test02(){

    }
}
