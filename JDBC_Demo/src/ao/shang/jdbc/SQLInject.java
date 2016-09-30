package ao.shang.jdbc;

import java.sql.*;

/**
 * Created by cai on 16-9-19.
 */
public class SQLInject {
    public static void main(String[] args) throws SQLException {
//        long start = System.currentTimeMillis();
        read("name1");
//        long end = System.currentTimeMillis();
//        System.out.println("read=" + (end - start));
//        start = System.currentTimeMillis();
        read1("name1");
//        end = System.currentTimeMillis();
//        System.out.println("read1="+(end - start));

    }

    public static void read(String name) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
//        创建语句
            String sql = "SELECT id,name,money,birthday FROM user where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
//        执行语句
            rs = ps.executeQuery();
        }
        long end = System.currentTimeMillis();
        System.out.println("read=" + (end - start));

//        处理结果
        while (rs.next()) {
            System.out.println(rs.getObject("id")+"\t"+rs.getObject("name")+"\t"+
                    rs.getObject("money")+"\t"+rs.getObject("birthday"));
        }
//        释放资源
        jdbcUtils.free(rs,ps,conn);
    }

    public static void read1(String name) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        conn = jdbcUtilsSing.getInstance().getConnection();
//        创建语句
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {

            String sql = "SELECT id,name,money,birthday FROM user where name='" + name + "'";
            st = conn.createStatement();

//        执行语句
            rs = st.executeQuery(sql);
        }
        long end = System.currentTimeMillis();
        System.out.println("read1=" + (end - start));
//        处理结果
        while (rs.next()) {
            System.out.println(rs.getObject("id")+"\t" +
                    rs.getObject("name")+"\t"+
                    rs.getObject("money")+"\t"+
                    rs.getObject("birthday"));
        }
//        释放资源
        jdbcUtils.free(rs,st,conn);
    }

}
