package ao.shang.cai.pro;

/**
 * 一个场景公用资源
 * 生产消费者模式 信号灯法
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class Movie {
    private String pic;
    /*
    * 当flag=false 消费者消费 生产者等待
    * 当flag=true 消费者等待生产者生产
    * */
    private boolean flag = true;


    public synchronized void play(String pic) {
        if (!flag) {    //生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        开始生产
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产"+pic);
//        生产完成
        this.pic = pic;
//        通知生产
        this.notify();
//        生产停止
        flag = false;

    }

    public synchronized void watch() {
        if (flag) { //消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        准备消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        消费完成
        System.out.println("消费"+pic);
//        通知消费
        this.notify();
//        消费停止
        flag = true;
    }
}
