package ao.shang.cai.syn;

/**
 *
 * 死锁   同步过多 共同使用同一份资源
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class SynDemo3 {
    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();
        Test test = new Test(g, m);
        Test2 test2 = new Test2(g, m);
        Thread proxy = new Thread(test);
        Thread proxy2 = new Thread(test2);
        proxy.start();
        proxy2.start();

    }



}

class Test implements Runnable{
    Object goods;
    Object money;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }


    @Override
    public void run() {
        while (true) {
            test();
        }
    }

    public void test(){
        synchronized (goods) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (money) {
            }

        }
        System.out.println("一手给钱");
    }
}

class Test2 implements Runnable{
    Object goods;
    Object money;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }


    @Override
    public void run() {
        while (true) {
            test();
        }
    }
    public void test(){
        synchronized (money) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods) {
            }

        }
        System.out.println("一手给货");

    }
}

