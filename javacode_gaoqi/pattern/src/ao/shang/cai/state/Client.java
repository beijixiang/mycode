package ao.shang.cai.state;

import ao.shang.cai.strategy.*;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Client {
    public static void main(String[] args) {

        Context context = new Context();
        context.setState(new FreeState());
        context.setState(new CheckedInState());
    }
}
