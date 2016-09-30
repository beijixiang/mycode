package ao.shang.cai.thread.creat;

/**
 * 实现接口Runable+c重写方法run
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class Programmer implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("一边打代码。。。。。。");


        }
    }
}
