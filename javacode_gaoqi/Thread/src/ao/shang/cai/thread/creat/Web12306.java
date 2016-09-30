package ao.shang.cai.thread.creat;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class Web12306 implements Runnable {

    @Override
    public void run() {
        int num = 50;
            while (true) {
                if (num <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"抢到票" + num--);

            }
    }

    public static void main(String[] args) {
//        创建真实角色
        Web12306 web = new Web12306();
//        创建代理对象
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "工程师");

        t1.start();
        t2.start();
        t3.start();

    }
}
