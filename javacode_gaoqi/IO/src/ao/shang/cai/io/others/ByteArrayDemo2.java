package ao.shang.cai.io.others;

import java.io.*;

/**
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class ByteArrayDemo2 {
    public static void main(String[] args) throws IOException {

        byte[] src = getByteArrFromFile("H:/javacode_gaoqi/a.txt");
        getFileFromByteArr(src, "H:/javacode_gaoqi/arr.txt");
    }

    /**
     * 字节数组-->程序-->文件
     * @param src
     * @param destPath
     * @throws IOException
     */
    public static void getFileFromByteArr(byte[] src, String destPath) throws IOException {
//        建立联系
        File dest = new File(destPath);
//        选择流
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
//        数据
        int len=0;
        byte[] flush = new byte[1024];
        while (-1 != (len = is.read(flush))) {
            os.write(flush, 0, len);
        }
//        强制刷出
        os.flush();
//        g关闭资源
        os.close();
        is.close();

    }


    /**
     * 文件-->程序-->字节数组
     * @param srcPath
     * @return
     */
    public static byte[] getByteArrFromFile(String srcPath) throws IOException {
//        创建源
        File src = new File(srcPath);
//        目的地
        byte[] dest =null;
//        选择流
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        ByteArrayOutputStream os = (new ByteArrayOutputStream());
//        读取数组
        int len = 0;
        byte[] flush = new byte[1024];
        while (-1 != (len = is.read(flush))) {
            os.write(flush, 0, len);
        }
//        强制刷出
        os.flush();
//        获取数据
        dest = os.toByteArray();

        return dest;
    }
}
