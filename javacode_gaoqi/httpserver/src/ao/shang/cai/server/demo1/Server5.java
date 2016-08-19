package ao.shang.cai.server.demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * <p>
 * Created by 蔡尚澳 on 2016/8/2.
 */
public class Server5 {
    ServerSocket server = null;
    public static final String CRLF = "\r\n";   //回车
    public static final String BLANK = " ";     //空格



    public static void main(String[] args) {

        Server5 server = new Server5();
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
//           请求信息
            Request req = new Request(client.getInputStream());



//            响应
            Respose rep = new Respose(client.getOutputStream());
            rep.println("<html><head><title>响应测试</title></head><body>");
            rep.println("欢迎：").println(req.getParameter("uname")).println(" 回来");
            rep.println("</body></html>");
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
