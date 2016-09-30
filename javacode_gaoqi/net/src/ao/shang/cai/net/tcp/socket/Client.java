package ao.shang.cai.net.tcp.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Client {

    public static void main(String[] args) throws IOException {
//        创建客户端并指定服务器端口及地址 此时就连接
        Socket client = new Socket("localhost", 8888);
//      接受数据

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String msg = br.readLine();
        System.out.println(msg);
        */
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);



    }

}
