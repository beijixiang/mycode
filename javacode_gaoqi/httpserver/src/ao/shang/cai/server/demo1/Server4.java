package ao.shang.cai.server.demo1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器
 * <p>
 * Created by 蔡尚澳 on 2016/8/2.
 */
public class Server4 {
    ServerSocket server = null;
    public static final String CRLF = "\r\n";   //回车
    public static final String BLANK = " ";     //空格



    public static void main(String[] args) {

        Server4 server = new Server4();
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

//            响应
            Respose rep = new Respose(client.getOutputStream());
            rep.println("<html><head><title>响应测试</title></head>");
            rep.println("<body>Hello Server</body></html>");
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
