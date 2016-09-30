package cn.bjsxt.opp.callBack;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class PainFrame {
    public static void drawFrame(IMyFrame frame){
        System.out.println("启动多线程");
        System.out.println("增加循环");
        System.out.println("查看消息栈");

        frame.pain();

        System.out.println("增加缓存");
    }

    public static void main(String[] args) {

        drawFrame(new GameFrame02());
    }
}

class GameFrame01 implements IMyFrame{
    @Override
    public void pain() {
        System.out.println("GameFrame01.pain");
        System.out.println("画框架");
    }
}

class GameFrame02 implements IMyFrame{
    @Override
    public void pain() {
        System.out.println("GameFrame02.pain");
        System.out.println("画框架");
    }
}
