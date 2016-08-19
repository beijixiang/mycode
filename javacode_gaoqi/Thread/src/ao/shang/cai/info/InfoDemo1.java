package ao.shang.cai.info;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class InfoDemo1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread it = new MyThread();
        Thread proxy = new Thread(it, "挨踢");
        proxy.setName("it");
        System.out.println(proxy.getName());
        System.out.println(Thread.currentThread().getName());

        proxy.start();
        System.out.println("启动后线程的状态" + proxy.isAlive());
        Thread.sleep(1);
        it.stop();
        Thread.sleep(100);
        System.out.println("线程停止后的状态" + proxy.isAlive());
    }
}
