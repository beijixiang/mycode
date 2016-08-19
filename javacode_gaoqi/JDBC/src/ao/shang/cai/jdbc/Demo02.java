package ao.shang.cai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 测试jdbc
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo02 {
    public static void main(String[] args) {


        Connection conn = null;
        Statement state = null;
        try {
//            加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
//            建立连接（实际上是一个socket远程连接，比较耗时）
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");
//
            state = conn.createStatement();
//            String sql = "insert into t_user (username,pwd,regTime) values ('王五',6666,now())";
//            state.execute(sql);

//            sql注入
            String id = "5 or 1=1";
            String sql = "delete from t_user where id=" + id;
            state.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (state != null) {
                    state.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
