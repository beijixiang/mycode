package ao.shang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cai on 16-9-19.
 */
public class CRUD {
    public static void main(String[] args) throws SQLException {
//        create();
//        update();
        delete();
        read();
    }

    public static void delete() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        st = conn.createStatement();
//        执行语句
        String sql = "delete FROM user where id >4";

        int i= st.executeUpdate(sql);

        System.out.println("i = " + i);
//        释放资源
        jdbcUtils.free(rs,st,conn);
    }

    public static void update() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        st = conn.createStatement();
//        执行语句
        String sql = "UPDATE user set money=money+10";
        int i= st.executeUpdate(sql);

        System.out.println("i = " + i);
//        释放资源
        jdbcUtils.free(rs,st,conn);
    }

    public static void create() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        st = conn.createStatement();
//        执行语句
        String sql = "insert into user(name,money,birthday) values('name1',400,'1980-01-01')";
        int i= st.executeUpdate(sql);

        System.out.println("i = " + i);
//        释放资源
        jdbcUtils.free(rs,st,conn);
    }


    public static void read() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        st = conn.createStatement();
//        执行语句
        rs = st.executeQuery("SELECT id,name,money,birthday FROM user");
//        处理结果
        while (rs.next()) {
            System.out.println(rs.getInt("id")+"\t"+
                    rs.getString("name")+"\t"+
                    rs.getFloat("money")+"\t"+
                    rs.getDate("birthday"));
        }
//        释放资源
        jdbcUtils.free(rs,st,conn);
    }

}
