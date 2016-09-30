package ao.shang.cai.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 * 服务器端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Server {
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
        double num =convert(packet.getData());
        System.out.println(num);
//        释放
        server.close();

    }

    public static double convert(byte[] data) throws IOException {

        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        double num = dis.readDouble();
        dis.close();
        return num;

    }

}
