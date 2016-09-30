package ao.shang.cai.server.demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * <p>
 * Created by 蔡尚澳 on 2016/8/2.
 */
public class Server6 {
    ServerSocket server = null;
    public static final String CRLF = "\r\n";   //回车
    public static final String BLANK = " ";     //空格



    public static void main(String[] args) {

        Server6 server = new Server6();
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
            Servlet serv = new Servlet();
            Request req = new Request(client.getInputStream());
            Respose rep = new Respose(client.getOutputStream());
            serv.service(req, rep);
            rep.pushToClient(200);


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
