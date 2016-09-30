package ao.shang.cai.net.tcp.chat.demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现聊天
 * 服务器端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Server {
    public static void main(String[] args) throws IOException {
//        创建服务器指定端口
        ServerSocket server = new ServerSocket(9999);
//        接受客户端
        Socket socket = server.accept();
//      接受数据
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
//        输出数据
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("服务器--->"+msg);
        dos.flush();


    }


}
