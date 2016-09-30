package ao.shang.cai.io.others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件分割
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class RndDemo1 {
    public static void main(String[] args) throws IOException {

        RandomAccessFile rnd = new RandomAccessFile(new File("H:/javacode_gaoqi/Demo2.java"), "r");
        rnd.seek(50);

        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = rnd.read(flush))) {
            if (len > 200) {
                System.out.println(new String(flush, 0, 200));
                break;
            } else {
                System.out.println(new String(flush, 0, len));
            }
        }
        rnd.close();
    }
}
