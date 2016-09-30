package ao.shang.cai.jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 *
 * 测试时间
 * Created by 蔡尚澳 on 2016/8/15.
 */
public class Demo08 {


    public static long str2Date(String destDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(destDate).getTime();

        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");

//            ps1 = conn.prepareStatement("SELECT * FROM t_user WHERE regTime>? and regTime<?");
//
//            Date start = new Date(str2Date("2016-08-07 00:00:00"));
//            Date end = new Date(str2Date("2016-08-10 00:00:00"));
//
//            ps1.setObject(1, start);
//            ps1.setObject(2, end);
//
//            rs = ps1.executeQuery();

            ps1 = conn.prepareStatement("SELECT * FROM t_user WHERE lastloginTime>? and lastloginTime<? ORDER BY lastloginTime");

            Timestamp start = new Timestamp(str2Date("2016-08-10 09:00:00"));
            Timestamp end = new Timestamp(str2Date("2016-08-10 18:00:00"));

            ps1.setObject(1, start);
            ps1.setObject(2, end);

            rs = ps1.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "--" + rs.getString("username") + "--" + rs.getTimestamp("lastloginTime"));

            }





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
