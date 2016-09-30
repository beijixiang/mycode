package ao.shang.cai.singleton;

/**
 * 单例模式  静态内部类 利用类加载天然的线程安全，提高效率，延迟加载
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class SingletonDemo4 {
//    类初始化时候立即加载对象，由于加载类时，天然是线程安全的

    private static class SingletonClassInstance {
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }
//    构造器私有化
    private SingletonDemo4(){

    }

//    方法没有同步，调用效率高
    public static SingletonDemo4 getInstance(){

        return SingletonClassInstance.instance;
    }

}
