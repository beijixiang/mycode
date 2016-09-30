package ao.shang.cai.testsorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试Object[]来封装一条记录
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class Demo01 {
    public static void main(String[] args) {


        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT empname,salary,age FROM Emp WHERE id>?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();


            while (rs.next()) {
                Object[] objs = new Object[3];
//                System.out.println(rs.getString(1) + "--" + rs.getDouble(2) + "--" + rs.getInt(3));
                objs[0] = rs.getObject(1);
                objs[1] = rs.getObject(2);
                objs[2] = rs.getObject(3);
                list.add(objs);
            }

            for (Object[] objs : list) {
                System.out.println("" + objs[0] + objs[1] + objs[2]);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }


    }
}
