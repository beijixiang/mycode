package ao.shang.cai.net.tcp.chat.demo4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现聊天
 * 服务器端
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class Server {

    private List<Mychannel> all = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        new Server().start();


    }



    public void start() throws IOException {
        //        创建服务器指定端口
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            //        接受客户端
            Socket socket = server.accept();
            Mychannel mychannel = new Mychannel(socket);
            all.add(mychannel);
            new Thread(mychannel).start();
        }
    }


    /**
     * 一个客户端一个线程
     */

    private class Mychannel implements Runnable{

        //        所有客户

//      数据输入输出管道
        private DataInputStream dis;
        private DataOutputStream dos;
        //        线程运行标识符
        private boolean isRunning = true;
        //        用户名
        private String name;


        public Mychannel(Socket socket) {
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                this.name = dis.readUTF();
                this.send("欢迎来到聊天室");
                this.sendOthers(this.name + "进入聊天室",true);

            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dis, dos);
                all.remove(this);
            }
        }

        /**
         * 数据接受
         * @return
         */

        public String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dis, dos);
                all.remove(this);

            }
            return msg;

        }

        public void send(String msg){
            //        输出数据
            if (msg == null || msg == "") {
                return;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();

            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dis, dos);
                all.remove(this);
            }

        }

        /**
         * 发送给其他客户端
         */
        public void sendOthers(String msg,boolean sys){

            if (msg.startsWith("@") && msg.indexOf(":") > -1) { //判断群聊还是私聊
                String name = msg.substring(1, msg.indexOf(":"));
                String str = msg.substring(msg.indexOf(":") + 1);
                System.out.println(name+"===========");
                System.out.println(str+"==========");
                for (Mychannel other : all) {
                    if (name.equals(other.name)) {
                        System.out.println(name + "========" + str);
                        other.send(this.name + "对你悄悄说：" + str);
                    }
                }

            }else {
                for (Mychannel other : all) {
                    if (other == this) {
                        continue;
                    }

                    if (sys) {  //判断是否为系统信息
                        other.send("系统信息:" + msg);

                    } else {
                        //                发送给其他客户
                        other.send(this.name + "对所有人说：" + msg);

                    }

                }
            }

        }


//
        @Override
        public void run() {
            while (isRunning) {
               sendOthers(receive(),false);
            }
        }
    }


}
