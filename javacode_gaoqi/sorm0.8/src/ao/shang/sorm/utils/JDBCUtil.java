package ao.shang.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装jdbc查询常用的操作
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class JDBCUtil {

    /**
     *   给sql设参数
     * @param ps    预编译sql语句对象
     * @param params    参数
     */
    public static void handleParams(PreparedStatement ps, Object[] params) {

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                try {
                    ps.setObject(i + 1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
