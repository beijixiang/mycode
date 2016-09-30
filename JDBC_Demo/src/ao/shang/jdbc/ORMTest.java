package ao.shang.jdbc;

import ao.shang.jdbc.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cai on 16-9-26.
 */
public class ORMTest {

    public static void main(String[] args) throws IllegalAccessException, SQLException, InvocationTargetException, InstantiationException {

        User user = (User) getObject("select id as Id,name as Name,birthday as Birthday," +
                "money as Money from user where id =1 ",User.class);
        System.out.println(user);

        Bean b=(Bean) getObject("select id as Id,name as Name,birthday as Birthday," +
                "money as Money from user where id =1 ",Bean.class);
        System.out.println(b);
    }

    public static Object getObject(String sql,Class clazz) throws SQLException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSetMetaData rsmd = ps.getMetaData();
            rs = ps.executeQuery();
            int count = rsmd.getColumnCount();
            String[] colNames = new String[count];
            for (int i = 1; i <= count; i++) {
                colNames[i - 1] = rsmd.getColumnLabel(i);
            }

            Object object = null;
            if (rs.next()) {
                object = clazz.newInstance();
                for (int i = 0; i < colNames.length; i++) {
                    String colName = colNames[i];
                    String methodName = "set" + colName;
                    Method[] methods = clazz.getMethods();
                    for (Method m : methods) {
                        if (methodName.equals(m.getName())) {
                            m.invoke(object, rs.getObject(colName));
                        }
                    }
                }
            }
            return object;
        } finally {
            jdbcUtils.free(rs, ps, conn);
        }
    }

}
