package ao.shang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cai on 16-9-22.
 */
public class TXTest {
    public static void main(String[] args) throws SQLException {
        test();
    }

    public static void test() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            conn = jdbcUtils.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();
            String sql = "update user set money=money-10 where id=1";
            st.executeUpdate(sql);

            sql = "select money from user where id=2";
            rs = st.executeQuery(sql);
            float money = 0.0f;
            if (rs.next()) {
                money = rs.getFloat("money");
            }
            if (money > 300) {
                throw new RuntimeException("超过最大值了");
            }
            sql = "update user set money=money+10 where id=2";
            st.executeUpdate(sql);
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            jdbcUtils.free(rs, st, conn);
        }


    }
}
