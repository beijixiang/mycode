package ao.shang.sorm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 蔡尚澳 on 2016/8/18.
 */
public interface CallBack {
    public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs);
}
