package ao.shang.cai.io.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 文件工具类
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class FileUtil {

    //    关闭流
//    ...为可变参数，只能放在形参的最后
    public static void close(Closeable... io) {
        for (Closeable temp : io) {
            try {
                temp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //    泛型方法
    public static <T extends Closeable> void closeAll(T... io) {
        for (Closeable temp : io) {
            try {
                temp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
