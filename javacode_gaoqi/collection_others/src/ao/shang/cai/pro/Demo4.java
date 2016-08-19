package ao.shang.cai.pro;

import java.io.IOException;
import java.util.Properties;

/**
 * 使用类路径读取文件
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
//        类相对路径
//        pro.load(Demo4.class.getResourceAsStream("/db.properties"));
        pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

        System.out.println(pro.getProperty("user"));

    }
}
