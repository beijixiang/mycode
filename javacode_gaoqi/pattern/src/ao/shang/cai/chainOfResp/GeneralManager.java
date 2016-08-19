package ao.shang.cai.chainOfResp;

/**
 * 主任
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class GeneralManager extends Leader {


    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {

        if (request.getLeaveDays() < 30) {
            System.out.println("员工：" + request.getEmpName() + "请假：" + request.getLeaveDays() +
                    "天，理由是：" + request.getReason());
            System.out.println("总经理：" + this.name + ",审批通过");
        } else {
            System.out.println("拒绝！！！！！！！！！！！");
        }
    }
}
