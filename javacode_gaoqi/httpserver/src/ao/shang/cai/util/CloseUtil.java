package ao.shang.cai.util;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 蔡尚澳 on 2016/8/4.
 */
public class CloseUtil {

    /**
     * 关闭io流
     * @param io
     */
    public static void closeIO(Closeable... io) {
        for (Closeable temp : io) {
            if (temp != null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void closeSocket(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeSocket(ServerSocket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
