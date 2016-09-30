package ao.shang.jdbc;

import java.sql.*;

/**
 * Created by cai on 16-9-23.
 */
public class PsTest {
    public static void main(String[] args) throws SQLException {

        ps();
    }
    public static void ps() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs = null;

        try {
            conn = jdbcUtils.getConnection();
            String sql = "{ call addUser(?,?,?,?)}";
            cs = conn.prepareCall(sql);
            cs.registerOutParameter(4, Types.INTEGER);
            cs.setString(1, "ps name");
            cs.setDate(2, new Date(System.currentTimeMillis()));
            cs.setFloat(3, 1000.0f);

            cs.executeUpdate();
            int id = cs.getInt(4);
            System.out.println("id= " + id);

        } finally {
            jdbcUtils.free(rs,cs,conn);

        }
    }

}
