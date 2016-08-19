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
public class Server {
    ServerSocket server = null;
    public static void main(String[] args) {

        Server server = new Server();
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
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while ((msg = br.readLine()).length() > 0) {

                sb.append(msg);
                sb.append("\r\n");
            }
            String requestInfo = sb.toString().trim();
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
