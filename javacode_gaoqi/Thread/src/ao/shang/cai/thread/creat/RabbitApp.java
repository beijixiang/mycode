package ao.shang.cai.thread.creat;

/**
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class RabbitApp {
    public static void main(String[] args) {
//        创建对象
        Rabbit rab = new Rabbit();
        Tortoise tor = new Tortoise();
//        调用start方法
        rab.start();    //不要调用run
        tor.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("main---->"+i);
        }

    }
}
