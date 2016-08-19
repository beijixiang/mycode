package ao.shang.cai.server.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * <p>
 * Created by 蔡尚澳 on 2016/8/2.
 */
public class Server2 {
    ServerSocket server = null;
    public static void main(String[] args) {

        Server2 server = new Server2();
        server.start();


    }

    /**
     * 服务器启动
     */
    public void start(){
        try {
            server = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 服务器接收请求
     */
    private void receive(){

        try {
            Socket client = server.accept();
            String msg = null;
            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);

//            客户端请求信息
            String requestInfo = new String(data, 0, len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务器停止
     */
    public void stop(){

    }

}
