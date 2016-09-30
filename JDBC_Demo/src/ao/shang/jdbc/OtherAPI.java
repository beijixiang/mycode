package ao.shang.jdbc;

import java.sql.*;

/**
 * Created by cai on 16-9-23.
 */
public class OtherAPI {
    public static void main(String[] args) throws SQLException, InterruptedException {
//        int id = create();
//        System.out.println("id:" + id);

        read();
    }

    public static void read() throws SQLException, InterruptedException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = jdbcUtils.getConnection();
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        rs = st.executeQuery("SELECT id,name,money,birthday FROM user where id <5");
        while (rs.next()) {
            int id = rs.getInt("id");
            System.out.println("show id =" + id);
            Thread.sleep(10000);
            System.out.println(id + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getFloat("money") + "\t" +
                    rs.getDate("birthday"));
        }
        jdbcUtils.free(rs,st,conn);
    }


    public static int create() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "insert into user(name,money,birthday) values('name1',400,'1980-01-01')";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        }finally {
            jdbcUtils.free(rs,ps,conn);

        }
    }

}
