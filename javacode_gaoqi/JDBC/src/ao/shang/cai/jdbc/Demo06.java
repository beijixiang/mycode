package ao.shang.cai.jdbc;

import java.sql.*;

/**
 *
 * 测试事务
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo06 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps1= null;
        PreparedStatement ps2= null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");

            conn.setAutoCommit(false);  //设置事务自动提交为false
            ps1 = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?,now())");
            ps1.setObject(1, "尚澳");
            ps1.setObject(2, 55555);
            ps1.execute();
            System.out.println("插入第一条");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ps2 = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?,now())");
            ps2.setObject(1, "hehehh");
            ps2.setObject(2, 55555);
            ps2.execute();
            System.out.println("插入第二条");

            conn.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {          //三个关闭要分开try、catch

            try {
                if (ps1 != null) {
                    ps1.close();
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
