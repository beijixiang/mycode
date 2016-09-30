package ao.shang.cai.net.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Arrays;

/**
 *
 * 客户端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Client {
    public static void main(String[] args) throws IOException {

//        创建客户端
        DatagramSocket client = new DatagramSocket(6666);
//        准备数据
//        String msg = "udp编程";
        double msg = 19.34;
        byte[] data = convert(msg);

//        数据打包 指定服务器地址端口
        DatagramPacket packet = new DatagramPacket(data, data.length,
                new InetSocketAddress("localhost", 8888));

//        发送数据
        client.send(packet);
//        释放资源
        client.close();

    }


    /**
     * double 转化为byte数组
     * @param num
     * @return
     * @throws IOException
     */
    public static byte[] convert(double num) throws IOException {
        byte[] data ;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);
        dos.flush();

//        获取数据
        data = bos.toByteArray();

        dos.close();
        return data;
    }


}
