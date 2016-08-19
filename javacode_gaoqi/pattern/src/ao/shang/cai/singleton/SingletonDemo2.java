package ao.shang.cai.singleton;

/**
 * 单例模式  懒汉式
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class SingletonDemo2 {
//    类初始化时候立即不加载对象，只有真正调用的时候才创建对象
    private static SingletonDemo2 instance;

//    构造器私有化
    private SingletonDemo2(){

    }

//    方法需要同步，调用效率高
    public static synchronized SingletonDemo2 getInstance(){
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }

}
