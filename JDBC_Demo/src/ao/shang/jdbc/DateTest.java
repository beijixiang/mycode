package ao.shang.jdbc;

import java.sql.*;
import java.util.Date;

/**
 * Created by cai on 16-9-20.
 */
public class DateTest {
    public static void main(String[] args) throws SQLException {
//        create("name2", new Date(), 500.0f);
        Date birthday = read(7);
        System.out.println(birthday);
    }

    public static Date read(int id) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        Date birthday = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        st = conn.createStatement();
//        执行语句
        rs = st.executeQuery("SELECT id,name,money,birthday FROM user where id=" + id);
//        处理结果
        while (rs.next()) {
//            birthday = new Date(rs.getDate("birthday").getTime());
            birthday = rs.getDate("birthday");
        }
//        释放资源
        jdbcUtils.free(rs,st,conn);
        return birthday;
    }


    public static void create(String name, Date birthday, float money) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        String sql = "insert into user(name,money,birthday) values(?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setFloat(2, money);
        ps.setDate(3, new java.sql.Date(birthday.getTime()));
//        执行语句
        int i = ps.executeUpdate();
        System.out.println("i = " + i);
//        释放资源
        jdbcUtils.free(rs, ps, conn);
    }

}
