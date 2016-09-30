package ao.shang.cai.info;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class MyThread implements Runnable {

    private boolean flag = true;
    private int num = 0;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName()+"--->"+num++);
        }

    }

    public void stop(){
        this.flag = !flag;
    }
}
