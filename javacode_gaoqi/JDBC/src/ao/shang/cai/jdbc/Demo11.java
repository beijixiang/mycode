package ao.shang.cai.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * 测试jdbcutil
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class Demo11 {

    public static void main(String[] args) {


        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getMysqlConn();
            state = conn.prepareStatement("INSERT into t_user (username) VALUES (?)");
            state.setObject(1, "王五");
            state.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
    }

}
