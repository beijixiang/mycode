package ao.shang.cai.thread.creat;

/**
 * 模拟龟兔赛跑
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class Rabbit extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("兔子跑了" + i + "步");
        }
    }
}

class Tortoise extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("乌龟跑了" + i + "步");
        }
    }
}