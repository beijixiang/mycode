package ao.shang.cai.status;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class YieldDemo1 extends Thread{
    public static void main(String[] args) {

        YieldDemo1 join = new YieldDemo1();
        Thread t = new Thread(join);
        t.start();
        for (int i = 0; i < 1000; i++) {
            if (i%20==0) {
//                暂停该main线程
                Thread.yield();
            }
            System.out.println("main......"+i);
        }

    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("jion......" + i);

        }

    }

}
