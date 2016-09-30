package ao.shang.cai.thread.creat;

import java.util.StringTokenizer;
import java.util.concurrent.*;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class Call {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//      创建线程
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Race tortoise = new Race("乌龟",1000);
        Race rabbit = new Race("兔子",500);
//        获取值
        Future<Integer> fu1 = ex.submit(tortoise);
        Future<Integer> fu2= ex.submit(rabbit);

        Thread.sleep(2000);
//        停止线程
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        int num1 = fu1.get();
        int num2 = fu2.get();
        System.out.println("兔子跑了" + num2 + "步");
        System.out.println("乌龟跑了" + num1 + "步");
//        停止服务
        ex.shutdown();

    }


}

class Race implements Callable<Integer>{

    private String name;
    //    步数
    private int step=0;
    //    延迟时间
    private long times;
    private boolean flag=true;

    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long times) {
        this.name = name;
        this.times = times;
    }

    @Override
    public Integer call() throws Exception {
        while (flag) {
            Thread.sleep(times);
            step++;
        }

        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
