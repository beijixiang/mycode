package ao.shang.cai.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试五种单例模式的时间
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client3 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        Object s1 = SingletonDemo5.INSTANCE;
                    }
                    countDownLatch.countDown();
                }
            }).start();

        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("所耗时间："+(end-start));


    }

}
