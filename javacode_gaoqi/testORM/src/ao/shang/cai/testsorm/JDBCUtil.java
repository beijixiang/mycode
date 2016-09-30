package ao.shang.cai.testsorm;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 *
 * jdbc常用类封装
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class JDBCUtil {

    static Properties properties = null;    //可以帮助处理资源文件


    static {
        properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static Connection getMysqlConn(){
        try {
            Class.forName(properties.getProperty("mysqlDriver"));
            return DriverManager.getConnection(properties.getProperty("mysqlUrl")
                    ,properties.getProperty("mysqlUser") ,properties.getProperty("mysqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(state, conn);
    }

    public static void close( Statement state, Connection conn) {

        try {
            if (state != null) {
                state.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
    }
    public static void close( Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
