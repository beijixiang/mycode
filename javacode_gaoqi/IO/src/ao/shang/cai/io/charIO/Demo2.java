package ao.shang.cai.io.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符的输出
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class Demo2 {
    public static void main(String[] args) {
//        建立联系
        String destPath = "H:/javacode_gaoqi/f.txt";
        File dest = new File(destPath);
//        选择流
        Writer wr = null;
        try {
            wr = new FileWriter(dest,true);
            String str = "sdfasddsfasd,dsfasdfs,dsfasd\r\n";
            wr.write(str);
            wr.append("dasdfsdfsa\r\n");
//            强制刷出
            wr.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件关闭失败");

            }
        }
    }
}
