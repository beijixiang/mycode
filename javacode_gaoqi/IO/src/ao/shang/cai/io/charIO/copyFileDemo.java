package ao.shang.cai.io.charIO;

import java.io.*;

/**
 * 文件的拷贝，仅限字符
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class copyFileDemo {
    public static void main(String[] args) {
//        建立联系
        File src = new File("H:/javacode_gaoqi/a.txt");
        File dest = new File("H:/javacode_gaoqi/f.txt");
//        选择流
        Reader re = null;
        Writer wr = null;

        try {
            re = new FileReader(src);
            wr = new FileWriter(dest);
            char[] flush = new char[1024];
            int len = 0;
            while (-1 != (len = re.read(flush))) {
                wr.write(flush, 0, len);
            }
            wr.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                wr.close();
                re.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件关闭失败");
            }
        }
    }
}
