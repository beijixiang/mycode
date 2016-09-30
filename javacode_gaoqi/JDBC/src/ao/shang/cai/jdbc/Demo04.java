package ao.shang.cai.jdbc;

import java.sql.*;

/**
 *
 * 测试jdbc
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo04 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");

            String sql = "SELECT id,username,pwd FROM  t_user WHERE id>?";    //?是占位符
            state = conn.prepareStatement(sql);

            state.setObject(1, 2);
            rs = state.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "----" + rs.getString(2) + "-------" + rs.getString(3));

            }


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
