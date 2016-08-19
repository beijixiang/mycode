package ao.shang.cai.server.demo1;

import ao.shang.cai.util.CloseUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by 蔡尚澳 on 2016/8/4.
 */
public class Dispatcher implements Runnable {
    private Socket client;
    private Respose rep;
    private Request req;

    private int code = 200;

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            rep = new Respose(client.getOutputStream());
            req = new Request(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            code = 500;
        }
    }

    @Override
    public void run() {

        Servlet serv = new Servlet();
        serv.service(req, rep);
        try {
            rep.pushToClient(code); //推送到客户端
        } catch (IOException e) {
//            e.printStackTrace();
        }
        try {
            rep.pushToClient(500);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CloseUtil.closeSocket(client);

    }
}
