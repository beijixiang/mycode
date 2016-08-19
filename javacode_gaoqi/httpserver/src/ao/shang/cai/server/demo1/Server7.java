package ao.shang.cai.server.demo1;

import ao.shang.cai.util.CloseUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * <p>
 * Created by 蔡尚澳 on 2016/8/2.
 */
public class Server7 {
    ServerSocket server = null;
    public static final String CRLF = "\r\n";   //回车
    public static final String BLANK = " ";     //空格

    private boolean isShutDown=false;


    public static void main(String[] args) {

        Server7 server = new Server7();
        server.start();


    }

    /**
     * 服务器启动
     */
    public void start(){
        start(8888);

    }

    public void start(int port){
        try {
            server  = new ServerSocket(port);
            receive();
        } catch (IOException e) {
//            e.printStackTrace();
            stop();
        }

    }

    /**
     * 服务器接收请求
     */
    private void receive(){


        try {
            while (!isShutDown) {
                Socket client = server.accept();
                new Thread(new Dispatcher(client)).start();

            }

        } catch (IOException e) {
//            e.printStackTrace();
            stop();
        }
    }

    /**
     * 服务器停止
     */
    public void stop(){

        isShutDown = true;
        CloseUtil.closeSocket(server);
    }

}
