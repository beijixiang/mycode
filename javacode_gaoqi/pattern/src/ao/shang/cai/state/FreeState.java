package ao.shang.cai.state;

/**
 * 空闲状态
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("房间空闲可以入住");

    }
}
