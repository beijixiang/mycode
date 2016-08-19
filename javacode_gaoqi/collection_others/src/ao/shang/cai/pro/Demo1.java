package ao.shang.cai.pro;

import java.util.Properties;

/**
 * properties的读写
 *1key 和value只能是字符串
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo1 {
    public static void main(String[] args) {
        //创建对象
        Properties pro = new Properties();
        //写入文件
        pro.setProperty("drivers", "oracle.jdbc.drivers.OracleDrivers");
//        pro.setProperty("url", "jdbc:oracle:thin:@localhost:1534:orcl");
        pro.setProperty("user", "score");
        pro.setProperty("pwd", "tiger");
        //获取
        String url = pro.getProperty("url", "test");
        System.out.println(url);


    }
}
