package ao.shang.cai.singleton;

import java.io.Serializable;

/**
 * 单例模式  懒汉式
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class SingletonDemo6 implements Serializable {
//    类初始化时候立即不加载对象，只有真正调用的时候才创建对象
    private static SingletonDemo6 instance;

//    构造器私有化
    private SingletonDemo6(){

        if (instance != null) {
            throw new RuntimeException("不能实例化两次");
        }
    }

//    方法需要同步，调用效率高
    public static synchronized SingletonDemo6 getInstance(){
        if (instance == null) {
            instance = new SingletonDemo6();
        }
        return instance;
    }

//    防止反序列化破解单例
    private Object readResolve(){
        return instance;
    }

}
