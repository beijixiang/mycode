package ao.shang.cai.command;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Invoke {

    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

//    业务方法，调用命令类方法
    public void call(){

        command.execute();
    }
}
