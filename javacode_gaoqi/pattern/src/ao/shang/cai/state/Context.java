package ao.shang.cai.state;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Context {

    private State state;


    public void setState(State state) {
        System.out.println("状态已修改");
        this.state = state;
        state.handle();

    }


}
