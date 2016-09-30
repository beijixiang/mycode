package ao.shang.cai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * 测试jdbc
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo01 {
    public static void main(String[] args) {


        Connection conn = null;
        try {
//            加载驱动类
            long start = System.currentTimeMillis();
            Class.forName("com.mysql.jdbc.Driver");
//            建立连接（实际上是一个socket远程连接，比较耗时）
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("连接耗时："+(end-start)+"ms");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
