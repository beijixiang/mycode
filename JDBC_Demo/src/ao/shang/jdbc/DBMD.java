package ao.shang.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by cai on 16-9-24.
 */
public class DBMD {
    public static void main(String[] args) throws SQLException {

        Connection conn = jdbcUtils.getConnection();
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println("db name:" + dbmd.getDatabaseProductName());
        System.out.println("tx:" + dbmd.supportsTransactions());
        conn.close();

    }



}
