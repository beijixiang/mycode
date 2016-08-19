package ao.shang.cai.gen04;

import java.util.Objects;

/**
 * ?类型不定，使用时确定类型
 * ?声明类型或者声明方法上，不能用来声明类或者使用时
 * ? extends <= 上限指定类型 自身或者子类
 * ? super >= 下限指定 类型自身或父类
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class Student<T> {
    T score;


    public static void main(String[] args) {
        Student<?> stu = new Student<String>();
        test(new Student<Integer>());
        test02(new Student<Apple>());
//        test03(new Student<Apple>()); //泛型没有多态
//        test04(new Student<Apple>());


        stu = new Student<Fruit>();
        //test04(stu);//使用时确定类型

        test04(new Student<Fruit>());
        test04(new Student<Object>());

    }

    public static void test(Student<?> student) {

    }

    public static void test03(Student<Fruit> f) {

    }

    public static void test02(Student<? extends Fruit> stu) {

    }

    public static void test04(Student<? super Fruit> stu) {

    }


}
