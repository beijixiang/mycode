package ao.shang.cai.syn;

/**
 * 线程同步 线程安全与不安全
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class SynDemo1 {
    public static void main(String[] args) {

        //        创建真实角色
        Web12306 web = new Web12306();
//        创建代理对象
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "工程师");
//        Thread t4 = new Thread(web, "爱妻");
//        Thread t5 = new Thread(web, "画师");

        t1.start();
        t2.start();
        t3.start();
//        t4.start();
//        t5.start();
    }
}

class Web12306 implements Runnable {

    private int num = 10;
    private boolean flag=true;

    @Override
    public void run() {
        while (flag) {
            test5();
        }
    }

//    线程不安全

    public void test6(){

            if (num <= 0) {
                flag = false;
                return;
            }
        synchronized (this) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
        }
    }

//    线程不安全 锁定资源不正确
    public void test5(){

        synchronized ((Integer)num) {

            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
        }
    }

//    范围锁定太小 线程不安全
    public void test4(){

        synchronized (this) {

            if (num <= 0) {
                flag = false;
                return;
            }
        }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到票" + num--);

    }

//    线程安全 同步块

    public void test3(){

        synchronized (this) {

            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
        }
    }

//    线程安全  同步方法

    public synchronized void test2(){

        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到票" + num--);
    }

//    线程不安全
    public void test1(){

        if (num <= 0) {
            flag = false;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到票" + num--);
    }
}