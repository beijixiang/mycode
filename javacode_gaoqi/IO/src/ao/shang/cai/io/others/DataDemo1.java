package ao.shang.cai.io.others;

import java.io.*;

/**
 * 数据类型处理流
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class DataDemo1 {
    public static void main(String[] args) {

        try {
//            write("H:/javacode_gaoqi/data.txt");
            read("H:/javacode_gaoqi/data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中获取数据
     * @param srcPath
     */
    public static void read(String srcPath) throws IOException {
//      创建源
        File src = new File(srcPath);
//       创建流
        DataInputStream is = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)));
//        读取数据
        double point = is.readDouble();
        long sum = is.readLong();
        String str = is.readUTF();

//        关闭资源
        is.close();
        System.out.println(point+"-->"+sum+"-->"+str);
    }

    /**
     * 数据类型写入文件
     * @param destPath
     */
    public static void write(String destPath) throws IOException {

        double point = 3.14;
        long sum = 100L;
        String string = "数据类型一致";

//        创建源
        File dest = new File(destPath);
//        选择流
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)));
//        数据写入  注意顺序
        dos.writeDouble(point);
        dos.writeLong(sum);
        dos.writeUTF(string);

        dos.flush();
        dos.close();

    }
}
