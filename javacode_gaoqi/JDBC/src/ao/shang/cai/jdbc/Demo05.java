package ao.shang.cai.jdbc;

import java.sql.*;

/**
 *
 * 测试jdbc
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo05 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");
//          关闭自动提交
            conn.setAutoCommit(false);
            long start = System.currentTimeMillis();
            state = conn.createStatement();
            for (int i = 10; i < 20010; i++) {
                state.addBatch("insert into t_user (username,pwd,regTime)" +
                        " VALUES ('尚" + i + "',6666,now())");
//                state.addBatch("DELETE FROM t_user WHERE id=" + i);
            }

            state.executeBatch();
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("插入两万条数据耗时："+(end-start));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {          //三个关闭要分开try、catch
            
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
