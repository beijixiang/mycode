package ao.shang.cai.io.others;

import java.io.*;

/**
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class ByteArrayDemo1 {
    public static void main(String[] args) throws IOException {
        read(write());
    }

    public static byte[] write() throws IOException {
//        目的地
        byte[] dest;
//        选择流
        ByteArrayOutputStream os = new ByteArrayOutputStream();
//      操作与写出
        String str = "字节数组操作与文件一样";
        byte[] date = str.getBytes();
        os.write(date, 0, date.length);
//        获取资源
        dest = os.toByteArray();
//        释放资源
        os.close();
        return dest;

    }

    public static void read(byte[] date) throws IOException {

        InputStream is = new BufferedInputStream(
                new ByteArrayInputStream(date));
        byte[] flush=new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush,0,len));
        }
        is.close();
    }
}
