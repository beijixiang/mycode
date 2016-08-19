package ao.shang.cai.jdbc;

import java.sql.*;
import java.util.Random;

/**
 *
 * 测试时间
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo07 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");

            for (int i = 0; i < 1000; i++) {

                ps1 = conn.prepareStatement("insert into t_user (username,pwd,regTime,lastloginTime) values (?,?,?,?)");
                ps1.setObject(1, "尚澳" + i);
                ps1.setObject(2, 55555);

                int rand = 100000000 + new Random().nextInt(1000000000);

                Date date = new Date(System.currentTimeMillis()-rand);
                Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand);

                ps1.setDate(3, date);
                ps1.setTimestamp(4, stamp);

                ps1.execute();
            }
            System.out.println("插入第一条");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
