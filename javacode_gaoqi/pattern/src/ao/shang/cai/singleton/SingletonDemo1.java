package ao.shang.cai.singleton;

/**
 * 单例模式  饿汉式
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class SingletonDemo1 {
//    类初始化时候立即加载对象，由于加载类时，天然是线程安全的
    private static SingletonDemo1 instance = new SingletonDemo1();

//    构造器私有化
    private SingletonDemo1(){

    }

//    方法没有同步，调用效率高
    public static SingletonDemo1 getInstance(){
        return instance;
    }

}
