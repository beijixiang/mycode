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
public class Server3 {
    ServerSocket server = null;
    public static final String CRLF = "\r\n";   //回车
    public static final String BLANK = " ";     //空格



    public static void main(String[] args) {

        Server3 server = new Server3();
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
            StringBuilder reposedContext = new StringBuilder();
            reposedContext.append("<html><head><title>响应测试</title></head>" +
                    "<body>Hello Html</body></html>");

            StringBuilder reposed = new StringBuilder();
//            http协议版本 状态代码 描述
            reposed.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
//            响应头
            reposed.append("Server:bjsxt Server/0.0.1").append(CRLF);
//
            reposed.append("Date:").append(new Date()).append(CRLF);
            reposed.append("Content-type:text/html;charset=GBK").append(CRLF);
//            正文字节长度
            reposed.append("Content-lenth:").append(reposedContext.toString().getBytes().length).append(CRLF);
//            正文之前
            reposed.append(CRLF);
//            正文
            reposed.append(reposedContext);

//            输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(reposed.toString());
            bw.flush();
            bw.close();


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
