package ao.shang.cai.io.others;

import java.io.*;

/**
 * 数据类型输出到字节数组中
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class DataDemo2 {
    public static void main(String[] args) {

        try {
//            byte[] bytes = write();
            read(write());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从字符数组中获取数据
     */
    public static void read(byte[] srcArr) throws IOException {
//      创建源

//       创建流
        DataInputStream is = new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(srcArr)));
//        读取数据
        double point = is.readDouble();
        long sum = is.readLong();
        String str = is.readUTF();

//        关闭资源
        is.close();
        System.out.println(point+"-->"+sum+"-->"+str);
    }

    /**
     * 数据类型写入字符数组
     */
    public static byte[] write() throws IOException {

        double point = 3.14;
        long sum = 100L;
        String string = "数据类型一致";

//        创建源
        byte[] destArr = null;
//        选择流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        bos));
//        数据写入  注意顺序
        dos.writeDouble(point);
        dos.writeLong(sum);
        dos.writeUTF(string);

        dos.flush();

        destArr = bos.toByteArray();

        bos.close();
        dos.close();


        return destArr;
    }
}
