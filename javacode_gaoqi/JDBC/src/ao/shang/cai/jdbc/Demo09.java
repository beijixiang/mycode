package ao.shang.cai.jdbc;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * 测试时间
 * Created by 蔡尚澳 on 2016/8/15.
 * */


public class Demo09 {


    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");

            ps = conn.prepareStatement("INSERT INTO t_user (username,pwd,myInfo) VALUES (?,?,?)");
            ps.setString(1, "尚澳");
            ps.setObject(2,31234);
//            直接将文本文件输入到数据库当中
//            ps.setClob(3, new FileReader(new File("f:/a.txt")));
//          将程序中的字符串输入到数据库中
//            ps.setClob(3, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaaaa".getBytes()))));

            ps = conn.prepareStatement("SELECT * FROM t_user WHERE id=?");
            ps.setObject(1,41020);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clob c = rs.getClob("myInfo");
                Reader reader = c.getCharacterStream();
                int temp = 0;
                while ((temp = reader.read()) !=-1) {
                    System.out.print((char) temp);
                }

            }
//            ps.executeUpdate();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {          //三个关闭要分开try、catch


            try {
                if (ps != null) {
                    ps.close();
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
