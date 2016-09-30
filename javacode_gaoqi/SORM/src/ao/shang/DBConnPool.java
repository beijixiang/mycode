package ao.shang;

import ao.shang.sorm.core.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/8/18.
 */
public class DBConnPool {

    /**
     * 连接池对象
     */
    private List<Connection> pool;
    /**
     * 连接池的最大值
     */
    private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
    /**
     * 连接池的最小值
     */
    private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();

    /**
     * 初始化连接池连接池达到最小数
     */
    public void initPool() {
        if (pool == null) {
            pool = new ArrayList<Connection>();
        }
        while (pool.size() < POOL_MIN_SIZE) {
            pool.add(DBManager.creatConn());
            System.out.println("初始化池，池中的连接数为" + pool.size());
        }

    }

    /**
     * 从连接池中获得一个连接
     * @return
     */
    public synchronized Connection getConnection(){

        int last_index = pool.size() - 1;
        Connection conn = pool.get(last_index);
        pool.remove(last_index);
        return conn;

    }

    /**
     * 将连接放回池中
     * @param conn
     */
    public synchronized void close(Connection conn){

        if (pool.size() >= POOL_MAX_SIZE) {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            pool.add(conn);
        }
    }

    public DBConnPool() {
        initPool();

    }
}
