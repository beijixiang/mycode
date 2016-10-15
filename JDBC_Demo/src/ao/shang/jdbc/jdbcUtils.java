package ao.shang.jdbc;

import ao.shang.jdbc.datasource.MyDataSource2;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by cai on 16-9-16.
 */
public final class jdbcUtils {
    private static String url = "jdbc:mysql://localhost:3306/jdbc";
    private static String user = "root";
    private static String password = "shang123456";
    private static DataSource myDataSource = null;

    private jdbcUtils(){

    }
    static {
        //        注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties prop=new Properties();
            InputStream is=jdbcUtils.class.getClassLoader().
                    getResourceAsStream("dbcpconfig.properties");
            prop.load(is);
            myDataSource= BasicDataSourceFactory.createDataSource(prop);
//            myDataSource = new MyDataSource2();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return myDataSource.getConnection();
    }

    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (conn != null) {
                        conn.close();
//                        myDataSource.free(conn);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

