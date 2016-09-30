package ao.shang.cai.net.tcp.chat.demo2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Receive implements Runnable {
    //    数据接收管道
    private DataInputStream dis;
    //    线程是否运行
    private boolean isRunning = true;

    public Receive(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
    }

    /**
     * 接收数据
     */
    public String receive(){
        //      接受数据
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dis);

        }
        return msg;
    }

    @Override
    public void run() {

        while (isRunning) {
            System.out.println(receive());

        }
    }
}
