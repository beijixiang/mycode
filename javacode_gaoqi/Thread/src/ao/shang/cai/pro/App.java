package ao.shang.cai.pro;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class App {
    public static void main(String[] args) {
//      创建共同资源
        Movie m = new Movie();
//        多线程
        Player p = new Player(m);
        Watcher w = new Watcher(m);
//          启动线程
        new Thread(p).start();
        new Thread(w).start();

       }
}
