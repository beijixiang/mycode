package ao.shang.cai.net.tcp.chat.demo4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Send implements Runnable {
    //  控制台输入
    private BufferedReader console;
    //    管道输出
    private DataOutputStream dos;
    //    线程运行标识符
    private boolean isRunning = true;
    //    用户名
    private String name;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client,String name) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
            this.name = name;
            send(this.name);
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(console, dos);

        }
    }

    /**
     * 获取控制台输入数据
     *
     * @return
     */

    private String getInfoFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
//            e.printStackTrace();

        }
        return "";
    }

    /**
     * 发送由控制台得到的数据
     */
    public void send(String msg) {
        //        输出数据
        try {
            if (msg != null && msg != "") {
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(console, dos);
        }

    }

    @Override
    public void run() {

        while (isRunning) {
            send(getInfoFromConsole());

        }
    }
}
