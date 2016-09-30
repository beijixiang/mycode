package ao.shang.cai.pro;

/**
 * 消费者
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class Watcher implements Runnable {
    private Movie m;

    public Watcher(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            m.watch();
        }
    }
}
