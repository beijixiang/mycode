package ao.shang.cai.chainOfResp;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Client {

    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new GeneralManager("王五");

//        设置链表关系
        a.setNextLeader(b);
        b.setNextLeader(c);

//        处理请假
        LeaveRequest request = new LeaveRequest("shabi", 10, "回家探亲");
        a.handleRequest(request);


    }
}
