package ao.shang.cai.command;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public interface Command {
    void execute();

}

class concreteCommand implements Command{

    //    持有真正的执行者
    private Receiver receiver;

    public concreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();

    }
}