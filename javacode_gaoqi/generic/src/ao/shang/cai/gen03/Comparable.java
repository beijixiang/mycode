package ao.shang.cai.gen03;

/**
 * 泛型接口
 * Created by 蔡尚澳 on 2016/7/18.
 */
public interface Comparable<T> {
    void compa(T t);
}

//声明子类具体类型
/*
class com1 implements Comparable<String> {


    @Override
    public void compa(String s) {

    }
}

//擦除
class com2 implements Comparable {

    @Override
    public void compa(Object o) {

    }
}

//父类擦除子类泛型
class com3<T> implements Comparable {

    @Override
    public void compa(Object o) {

    }
}

//子类泛型》>=父类泛型
class com4<T> implements Comparable<T> {
    @Override
    public void compa(T t) {

    }
}

//父类泛型子类擦除  错误
*/
