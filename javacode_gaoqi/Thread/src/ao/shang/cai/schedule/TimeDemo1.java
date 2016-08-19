package ao.shang.cai.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调用
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class TimeDemo1 {
    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("so easy......");
            }
        }, new Date(System.currentTimeMillis() + 1000),1000);

    }
}
