package ao.shang.cai.gen03;

import com.sun.javafx.font.t2k.T2KFactory;

/**
 *
 *
 * 子类父类要么同时擦除要么子类大于父类
 * 不能子类擦除，父类泛型
 * 属性
 * 父类中由父类而定
 * 子类中由子类定
 *
 * 方法重写
 * 由父类而定
 * Created by 蔡尚澳 on 2016/7/18.
 */
public abstract class Father<T1, T2> {
    T1 name;

    public abstract void test(T1 t);
}

/**
 * 子类声明时指定具体类型
 * 属性为具体类型
 * 方法同理
 */
class child extends Father<String, Integer> {

    @Override
    public void test(String t) {

    }
}

/**
 * 子类为泛型类
 *
 *
 */
class child2<T1, T2> extends Father<T1, T2> {

    T1 name;
    @Override
    public void test(T1 t) {

    }
}

/*
* 子类泛型，父类不指定泛型,类型擦除，使用Object代替
*
*
*/
class child3<T1, T2> extends Father {

    @Override
    public void test(Object t) {

    }
}
/*
* 子类父类同事擦除，
*
* */
class child4 extends Father {
    String name;
    @Override
    public void test(Object t) {

    }
}

/*
* 错误类型子类擦除父类使用泛型
*class child5 extends Father<T1, T2> {
    @Override
    public void test(T1 t) {

    }
}
* */


