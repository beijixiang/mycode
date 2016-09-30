package ao.shang.cai.jdbc;

import java.io.*;
import java.sql.*;

/**
 *
 * 测试时间
 * Created by 蔡尚澳 on 2016/8/15.
 * */


public class Demo10 {


    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest"
                    ,"root" ,"shang123456");

//            ps = conn.prepareStatement("INSERT INTO t_user (username,pwd,headImg) VALUES (?,?,?)");
//            ps.setString(1, "尚澳");
//            ps.setObject(2,31234);
//            直接将文本文件输入到数据库当中
//            ps.setBlob(3, new FileInputStream(new File("f:/headImg.jpg")));


            ps = conn.prepareStatement("SELECT * FROM t_user WHERE id=?");
            ps.setObject(1,41021);
            rs = ps.executeQuery();


            while (rs.next()) {
                Blob c = rs.getBlob("headImg");
                is = c.getBinaryStream();
                os = new FileOutputStream("f:/b.jpg");

                int temp = 0;
                while ((temp = is.read()) !=-1) {
                    os.write(temp);
                }
                os.flush();

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
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
