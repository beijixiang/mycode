package ao.shang.cai.status;

/**
 * 线程状态
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class Demo1 {

    public static void main(String[] args) {
        Study s = new Study();
        new Thread(s).start();
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                s.stop();
            }
            System.out.println("main......");
        }
    }

}

class Study implements Runnable {
//表示
    private boolean flag = true;

    @Override
    public void run() {

        while (flag) {
//          使用标识停止
            System.out.println("study......");

        }
    }

    public void stop(){
        flag = false;
    }
}
