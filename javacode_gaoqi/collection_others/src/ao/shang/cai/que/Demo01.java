package ao.shang.cai.que;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *模拟银行排队业务
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo01 {
    public static void main(String[] args) {
        Queue<Request> que = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            final int num = i;
            que.offer(new Request() {
                @Override
                public void deposit() {
                    System.out.println("第" + (num+1) + "个人存款，额度为：" + Math.random() * 10000);
                }
            });
        }
        dealWith(que);
    }

    //     业务处理
    public static void dealWith(Queue<Request> que) {
        Request req = null;
        while (null != (req = que.poll())) {
            req.deposit();
        }
    }



}
interface Request{
//       存款
    void deposit();
}
