package ao.shang.cai.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 *
 * 客户端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class MyClient {
    public static void main(String[] args) throws IOException {

//        创建客户端
        DatagramSocket client = new DatagramSocket(6666);
//        准备数据
        String msg = "udp编程";
        byte[] data = msg.getBytes();
//        数据打包 指定服务器地址端口
        DatagramPacket packet = new DatagramPacket(data, data.length,
                new InetSocketAddress("localhost", 8888));

//        发送数据
        client.send(packet);
//        释放资源
        client.close();

    }


}
