package ao.shang.cai.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程暂停
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class SleepDemo1 {
    public static void main(String[] args) throws InterruptedException {
//
        Date endtime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endtime.getTime();
        while (true) {
//            输出
            System.out.println(new SimpleDateFormat("mm:ss").format(endtime));
//            等待下一秒
            endtime = new Date(endtime.getTime() - 1000);
            Thread.sleep(1000);
//            不在十秒以外退出
            if (end - 10000 > endtime.getTime()) {
                break;
            }
        }


    }

    public void test1() throws InterruptedException {
        int num = 10;
        while (true) {
            System.out.println(num--);
            Thread.sleep(1000); //暂停
            if (num == 0) {
                break;
            }

        }
    }
}
