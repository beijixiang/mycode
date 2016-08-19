package ao.shang.cai.command;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Client {
    public static void main(String[] args) {
        Command command = new concreteCommand(new Receiver());
        Invoke invoke = new Invoke(command);

        invoke.call();

    }
}
