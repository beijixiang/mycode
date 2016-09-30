package ao.shang.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cai on 16-9-24.
 */
public class ResultSetMetaTest {
    public static void main(String[] args) throws SQLException {

        List<Map<String, Object>> dates = read("SELECT id,name,money,birthday FROM user where id<5");
        System.out.println(dates);
    }

    public static List<Map<String, Object>> read(String sql) throws SQLException {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSetMetaData rsmd = ps.getMetaData();
            rs = ps.executeQuery();
            int count = rsmd.getColumnCount();
            String[] colName = new String[count];
            for (int i = 1; i <= count; i++) {
//                System.out.print(rsmd.getColumnClassName(i) + "\t");
//                System.out.print(rsmd.getColumnName(i) + "\t");
//                System.out.println(rsmd.getColumnLabel(i));

                colName[i - 1] = rsmd.getColumnLabel(i);
            }
            List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> data = new HashMap<String, Object>();
                for (int i = 0; i < colName.length; i++) {
                    data.put(colName[i], rs.getObject(colName[i]));
                }

                datas.add(data);
//                System.out.println(rs.getInt("id") + "\t" +
//                        rs.getString("name") + "\t" +
//                        rs.getFloat("money") + "\t" +
//                        rs.getDate("birthday"));
            }
            return datas;
        } finally {
            jdbcUtils.free(rs, ps, conn);
        }
    }

}
