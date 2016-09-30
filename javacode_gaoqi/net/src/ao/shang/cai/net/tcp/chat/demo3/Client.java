package ao.shang.cai.net.tcp.chat.demo3;

import java.io.IOException;
import java.net.Socket;

/**
 * 实现聊天
 * 客户端
 * 创建多线程，实现发送与接受数据独立
 *
 *
 *
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Client {
    public static void main(String[] args) throws IOException {
//        创建客户端
        Socket client = new Socket("localhost", 9999);
//        控制台输入
        new Thread(new Send(client)).start();     //创建一条发送线程
        new Thread(new Receive(client)).start();     //创建一条接收线程


    }
}
