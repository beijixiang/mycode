package ao.shang.cai.io.byteIo;

import java.io.*;

/**
 * 读取文件
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo1 {
    public static void main(String[] args) {
//      建立联系
        File src = new File("H:/javacode_gaoqi/a.txt");
//      提升作用域
        InputStream is = null;
        try {
            //        关联
            is= new FileInputStream(src);
//            操作
            byte[] bytes = new byte[10];
//            文件字节数
            int len = 0;
            while (-1 != (len = is.read(bytes))) {
//                输出字节数组成字符串
                String ifon = new String(bytes, 0, len);
                System.out.println(ifon);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭文件失败");
                }

            }
        }

    }
}
