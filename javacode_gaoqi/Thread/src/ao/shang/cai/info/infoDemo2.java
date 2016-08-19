package ao.shang.cai.info;

/**
 * 优先级
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class infoDemo2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread it1 = new MyThread();
        Thread p1 = new Thread(it1, "挨踢1");
        MyThread it2 = new MyThread();
        Thread p2 = new Thread(it2, "挨踢2");

        p1.setPriority(Thread.MIN_PRIORITY);    //设置优先级
        p2.setPriority(Thread.MAX_PRIORITY);

        p1.start();
        p2.start();

        Thread.sleep(1000);
        it1.stop();
        it2.stop();
    }
}
