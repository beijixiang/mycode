package ao.shang.cai.thread.creat;

/**
 * Created by 蔡尚澳 on 2016/7/31.
 */
public class ProgrammerApp {
    public static void main(String[] args) {
//        创建真实角色
        Programmer pro = new Programmer();
//        创建代理对象
        Thread proxy = new Thread(pro);
//        静态代理，调用start方法
        proxy.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("一边聊qq。。。。");
        }

    }
}
