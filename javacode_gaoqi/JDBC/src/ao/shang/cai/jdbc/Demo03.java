package ao.shang.cai.jdbc;

import java.sql.*;

/**
 *
 * 测试jdbc
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo03 {
    public static void main(String[] args) {


        Connection conn = null;
        PreparedStatement state = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");

            String sql = "INSERT INTO t_user (username,pwd,regTime) VALUES (?,?,?)";    //?是占位符
            state = conn.prepareStatement(sql);
//
//            state.setString(1, "尚澳");
//            state.setInt(2, 123445);
//            state.setDate(3, new Date(System.currentTimeMillis()));

            state.setObject(1, "尚澳4");
            state.setObject(2, 123456);
            state.setObject(3,new Date(System.currentTimeMillis()));

            System.out.println("插入一行记录");
//            state.execute();
            int count = state.executeUpdate();
            System.out.println(count);

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
