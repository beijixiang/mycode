package ao.shang.jdbc;

import java.sql.*;

/**
 * Created by cai on 16-9-16.
 */
public final class jdbcUtilsSing {
    private String url = "jdbc:mysql://localhost:3306/jdbc";
    private String user = "root";
    private String password = "shang123456";

    //    private static jdbcUtilsSing instance=new jdbcUtilsSing();
    private static jdbcUtilsSing instance = null;

    private  jdbcUtilsSing() {

    }

    public static jdbcUtilsSing getInstance(){
        if (instance == null) {
            synchronized (jdbcUtilsSing.class) {
                if (instance == null) {
                    instance = new jdbcUtilsSing();
                }
            }
        }
        return instance;
    }

    static {
        //        注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void free(ResultSet rs, Statement st, Connection conn) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

