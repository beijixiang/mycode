package ao.shang.cai.net.tcp.socket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Server {
    public static void main(String[] args) throws IOException {
//        创建服务器断开
        ServerSocket server = new ServerSocket(8888);
//        接受连接
        Socket socket=server.accept();

        System.out.println("一个客户端建立连接");
//        发送数据
        String msg = "欢迎使用";

        /*

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(msg);
        bw.newLine();
        bw.flush();
        */

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
    }
}
