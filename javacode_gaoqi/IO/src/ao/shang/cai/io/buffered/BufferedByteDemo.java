package ao.shang.cai.io.buffered;

import java.io.*;

/**
 * 字节缓冲流
 * 只需要加入缓冲就行
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class BufferedByteDemo {
    public static void main(String[] args) {

    }
    public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
//        建立联系
        File src = new File(srcPath);
        File dest = new File(destPath);
//        判断是否为文件，不是返回错误
        if (!src.isFile()) {
            throw new IOException("只能拷贝文件");
        }
//        输入输出流
        byte[] flush = new byte[1024];
        InputStream is =new BufferedInputStream(new FileInputStream(src)) ;
        OutputStream os =new BufferedOutputStream( new FileOutputStream(dest));
        int len = 0;
//        循环读取写入
        while (-1!= (len=is.read(flush))) {
            os.write(flush,0,len);
        }
//        强制输出
        os.flush();
//       关闭输入输出流
        os.close();
        os.close();
    }
}
