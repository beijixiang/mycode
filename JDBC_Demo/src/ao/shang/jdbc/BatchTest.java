package ao.shang.jdbc;

import java.sql.*;

/**
 * Created by cai on 16-9-23.
 */
public class BatchTest {
    public static void main(String[] args) throws SQLException {

        long start = System.currentTimeMillis();
        for (int i=0;i<100;i++) {
            create(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("create:" + (end - start));
        start = System.currentTimeMillis();
        batchCreate();
        end = System.currentTimeMillis();
        System.out.println("batchCreate:" + (end - start));



    }

    public static void create(int i) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {

            conn = jdbcUtils.getConnection();
            String sql = "insert into user(name,money,birthday) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "no batch name" + i);
            ps.setFloat(2, 100.0f + i);
            ps.setDate(3, new Date(System.currentTimeMillis()));

            ps.executeUpdate();

        }finally {
            jdbcUtils.free(rs,ps,conn);
        }
    }
    public static void batchCreate() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {

            conn = jdbcUtils.getConnection();
            String sql = "insert into user(name,money,birthday) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 100; i++) {

                ps.setString(1, "batch name" + i);
                ps.setFloat(2, 100.0f + i);
                ps.setDate(3, new Date(System.currentTimeMillis()));
                ps.addBatch();
            }
            int[] is = ps.executeBatch();

        }finally {
            jdbcUtils.free(rs,ps,conn);
        }
    }
}
