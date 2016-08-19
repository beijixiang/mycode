package ao.shang.cai.syn;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class MyJvm {
    private static MyJvm instance = null;

    public MyJvm() {
    }

//懒汉式
    public static MyJvm getInstance() {
        if (instance == null) {
            synchronized (MyJvm.class) {
                if (instance == null) {
                    instance = new MyJvm();
                }
            }
        }
        return instance;
    }
}

/**
 * 饿汉式
 */

class MyJvm2 {
    private static MyJvm2 instance = new MyJvm2();

    public MyJvm2() {
    }

    //懒汉式
    public static MyJvm2 getInstance() {
        return instance;
    }
}

/**
 * 延缓类对象的创建时间
 */

class MyJvm3 {
    private static class JvmHolder {
        private static MyJvm3 instance = new MyJvm3();
    }
    public MyJvm3() {
    }

    //懒汉式
    public static MyJvm3 getInstance() {
        return JvmHolder.instance;
    }
}
