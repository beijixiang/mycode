package ao.shang.cai.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务器端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
//        创建服务器端及指定端口
        DatagramSocket server = new DatagramSocket(8888);
//        准备容器
        byte[] container = new byte[1024];
//        封装成包
        DatagramPacket packet = new DatagramPacket(container, container.length);
//        接受数据
        server.receive(packet);
//        分析数据
        byte[] data = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(data, 0, len));
//        释放
        server.close();

    }

}
