package ao.shang.cai.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**使用properties输出配置文件
 *
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        //创建对象
        Properties pro = new Properties();
        //写入文件
        pro.setProperty("drivers", "oracle.jdbc.drivers.OracleDrivers");
        pro.setProperty("url", "jdbc:oracle:thin:@localhost:1534:orcl");
        pro.setProperty("user", "score");
        pro.setProperty("pwd", "tiger");

//        存贮到绝对路径
        pro.store(new FileOutputStream(new File("H:/javacode_gaoqi/db.properties")), "db");
        pro.storeToXML(new FileOutputStream(new File("H:/javacode_gaoqi/db.xml")), "db");
//        存放到相对路径
        pro.store(new FileOutputStream(new File("db.properties")), "db");
        pro.store(new FileOutputStream(new File("src/db.properties")), "db");
    }
}
