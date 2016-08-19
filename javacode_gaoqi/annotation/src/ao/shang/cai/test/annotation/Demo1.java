package ao.shang.cai.test.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 注解测试
 * Created by 蔡尚澳 on 2016/8/5.
 */
public class Demo1 /* extends Object*/{
    public static void main(String[] args) {
        Date d = new Date();
        test01();

    }

    @SuppressWarnings("all")
    public static void test002() {
        List list = new ArrayList();
        List list1 = new ArrayList();
    }

    @Deprecated
    public static void test01(){
        System.out.println("test01");

    }

    @Override
    public String toString() {
        return "";
    }


}
