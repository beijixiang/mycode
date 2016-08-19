package ao.shang.cai.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 读取properties文件
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
//        读取绝对路径
        Properties pro = new Properties();
//        pro.load(new FileReader("H:/javacode_gaoqi/db.properties"));
//        读取相对路径
        pro.load(new FileReader("src/db.properties"));
        System.out.println(pro.getProperty("user","test"));

    }
}
