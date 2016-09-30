package ao.shang.cai.net.tcp.chat.demo4;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class CloseUtil {
    public static void closeAll(Closeable... io) {
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
}
