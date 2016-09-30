package ao.shang.cai.io.charIO;

import java.io.*;

/**
 * 字符的读取
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class Demo1 {
    public static void main(String[] args) {
        String srcPath = "H:/javacode_gaoqi/a.txt";
//        建立联系
        File src = new File(srcPath);
//        选择流
        Reader re = null;
        try {
            re = new FileReader(src);
            char[] flush = new char[1024];
            int len = 0;
            while (-1 != (len = re.read(flush))) {
                String str = new String(flush);
                System.out.println(str);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        }finally {
            try {
                re.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件关闭失败");
            }
        }
    }
}
