package ao.shang.cai.status;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        //        创建真实角色
        Web12306 web = new Web12306();
//        创建代理对象
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "工程师");
        Thread t4 = new Thread(web, "爱妻");
        Thread t5 = new Thread(web, "画师");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
class Web12306 implements Runnable {

    @Override
    public void run() {
        int num = 50;
        while (true) {
            if (num <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到票" + num--);

        }
    }
}

