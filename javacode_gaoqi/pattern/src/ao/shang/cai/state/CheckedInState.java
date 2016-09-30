package ao.shang.cai.state;

/**
 * 房间已经入住
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("房间已经入住");

    }
}
