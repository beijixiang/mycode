package ao.shang.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cai on 16-9-23.
 */
public class ScrollTest {
    public static void main(String[] args) throws SQLException {
        scroll();
    }

    public static void scroll() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        conn = jdbcUtils.getConnection();
        st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        rs = st.executeQuery("SELECT id,name,money,birthday FROM user ");
        int i = 0;
        rs.absolute(150);
        while (rs.next() && i < 10) {
            i++;
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getFloat("money") + "\t" +
                    rs.getDate("birthday"));
        }
        System.out.println("-----------------------");
        if (rs.previous()) {
            System.out.println(rs.getInt("id")+"\t"+
                    rs.getString("name")+"\t"+
                    rs.getFloat("money")+"\t"+
                    rs.getDate("birthday"));
        }
        jdbcUtils.free(rs,st,conn);
    }

}
