package ao.shang.jdbc;

import java.sql.*;

/**
 * Created by cai on 16-9-15.
 */

public class Base {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        template();
    }

    static void template() throws SQLException {

        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        st = conn.createStatement();
//        执行语句
        rs = st.executeQuery("SELECT * FROM user");
//        处理结果
        while (rs.next()) {
            System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+
                    rs.getObject(3)+"\t"+rs.getObject(4));
        }
//        释放资源
        jdbcUtils.free(rs,st,conn);

    }


    static void test() throws SQLException, ClassNotFoundException {
//        注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        System.setProperty("jdbc.drives", "com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
//        建立连接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "shang123456";
        Connection coon = DriverManager.getConnection(
                url, user, password);
//        创建语句
        Statement st = coon.createStatement();
//        执行语句
        ResultSet rs = st.executeQuery("SELECT * FROM user");
//        处理结果
        while (rs.next()) {
            System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+
            rs.getObject(3)+"\t"+rs.getObject(4));
        }
//        释放资源
        rs.close();
        st.close();
        coon.close();


    }
}
