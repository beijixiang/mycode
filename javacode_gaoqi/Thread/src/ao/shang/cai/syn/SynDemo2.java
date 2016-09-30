package ao.shang.cai.syn;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class SynDemo2 {
    public static void main(String[] args) {

        JvmThread jvm1 =new JvmThread(100);
        JvmThread jvm2 =new JvmThread(500);
        jvm1.start();
        jvm2.start();



    }
}


class JvmThread extends Thread {
    private long times;

    public JvmThread() {
    }

    public JvmThread(long times) {
        this.times = times;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Jvm.getInstance(times));
    }
}




/**
 * 单例设计模式
 * 1：创建私有构造器
 */

class Jvm {
    private static Jvm instance = null;

    private Jvm(){

    }
//      double checking
    public static Jvm getInstance(long times){
        if (instance == null) {
            synchronized (Jvm.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(times);     //放大出错概率
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    instance = new Jvm();
                }
            }
        }
        return instance;

    }

//    效率不高
    public static Jvm getInstance3(long times){
        synchronized (Jvm.class) {
            if (instance == null) {
                try {
                    Thread.sleep(times);     //放大出错概率
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                instance = new Jvm();
            }
            return instance;
        }
    }


    public static synchronized Jvm getInstance2(long times){
        if (instance == null) {
            try {
                Thread.sleep(times);     //放大出错概率
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Jvm();
        }
        return instance;
    }

    public static Jvm getInstance1(long times){
        if (instance == null) {
            try {
                Thread.sleep(times);     //放大出错概率
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Jvm();
        }
        return instance;
    }

}
