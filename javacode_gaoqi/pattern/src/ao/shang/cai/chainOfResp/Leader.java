package ao.shang.cai.chainOfResp;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public abstract class Leader {

    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

//    设定下一个责任链


    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

//    处理业务的核心
    public abstract void handleRequest(LeaveRequest request);


}
