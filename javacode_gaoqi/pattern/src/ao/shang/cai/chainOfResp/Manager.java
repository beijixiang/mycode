package ao.shang.cai.chainOfResp;

/**
 * 经理
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Manager extends Leader {


    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {

        if (request.getLeaveDays() < 10) {
            System.out.println("员工：" + request.getEmpName() + "请假：" + request.getLeaveDays() +
                    "天，理由是：" + request.getReason());
            System.out.println("经理：" + this.name + ",审批通过");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
