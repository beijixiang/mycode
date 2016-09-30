package ao.shang.jdbc;

import java.sql.*;

/**
 * Created by cai on 16-9-24.
 */
public class ParameterMetaTest {
    public static void main(String[] args) throws SQLException {

        Object[] params = new Object[]{"lisi", new Date(System.currentTimeMillis()), 100f};
        read("select * from user where name=? and birthday<? and money>?", params);

    }

    public static void read(String sql, Object[] params) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        conn = jdbcUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ParameterMetaData pmd = ps.getParameterMetaData();
        int count = pmd.getParameterCount();

        for (int i=1;i<=params.length;i++) {
//            System.out.print(pmd.getParameterClassName(i)+"\t");
//            System.out.print(pmd.getParameterType(i)+"\t");
//            System.out.println(pmd.getParameterTypeName(i));
            ps.setObject(i, params[i - 1]);
        }

        rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getFloat("money") + "\t" +
                    rs.getDate("birthday"));
        }
        jdbcUtils.free(rs, ps, conn);
    }


}
