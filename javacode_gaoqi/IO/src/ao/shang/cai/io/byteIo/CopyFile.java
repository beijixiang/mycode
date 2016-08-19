package ao.shang.cai.io.byteIo;

import java.io.*;

/**
 * 拷贝文件
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class CopyFile {
    public static void main(String[] args) {
        String src = "H:/javacode_gaoqi/a.txt";
        String dest = "H:/javacode_gaoqi/c.txt";
        try {
            copyFile(src, dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件拷贝失败或者问件关闭失败");
        }
    }

    public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException{
//        建立联系
        File src = new File(srcPath);
        File dest = new File(destPath);
//        判断是否为文件，不是返回错误
        if (!src.isFile()) {
            throw new IOException("只能拷贝文件");
        }
//        输入输出流
        byte[] flush = new byte[1024];
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);
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
