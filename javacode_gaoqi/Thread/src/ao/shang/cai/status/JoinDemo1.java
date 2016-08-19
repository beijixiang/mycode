package ao.shang.cai.status;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class JoinDemo1 extends Thread {
    public static void main(String[] args) throws InterruptedException {

        JoinDemo1 join = new JoinDemo1();
        Thread t = new Thread(join);
        t.start();
        for (int i = 0; i < 1000; i++) {
            if (i== 50) {
                t.join();
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
