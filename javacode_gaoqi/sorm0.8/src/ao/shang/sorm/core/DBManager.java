package ao.shang.sorm.core;

import ao.shang.sorm.pool.DBConnPool;
import ao.shang.sorm.bean.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 根据配置信息，维持连接对象的管理（增加连接池的功能）
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class DBManager {

    /**
     * 配置信息
     */
    private static Configuration conf;
    /**
     * 数据库连接池
     */
    private static DBConnPool pool;

    static {
        Properties pros = new Properties();

        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        conf = new Configuration();
        conf.setDriver(pros.getProperty("driver"));
        conf.setPoPackage(pros.getProperty("poPackage"));
        conf.setPwd(pros.getProperty("pwd"));
        conf.setSrcpath(pros.getProperty("srcpath"));
        conf.setUrl(pros.getProperty("url"));
        conf.setUsingDB(pros.getProperty("usingDB"));
        conf.setUser(pros.getProperty("user"));
        conf.setQueryClass(pros.getProperty("queryClass"));
        conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
        conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));

        System.out.println(TableContext.class);
    }

    public static Configuration getConf() {
        return conf;
    }

    public static void setConf(Configuration conf) {
        DBManager.conf = conf;
    }

    /**
     * 获得Connection对象
     * @return
     */
    public static Connection getConn(){

        if (pool == null) {
            pool=new DBConnPool();
        }
        return pool.getConnection();
    }

    /**
     * 创建新的Connection对象
     * @return
     */
    public static Connection creatConn(){
        try {
            Class.forName(conf.getDriver());
            return DriverManager.getConnection(conf.getUrl()
                    , conf.getUser(), conf.getPwd());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭statement对象、Connection对象、resultset对象
     * @param state
     * @param conn
     * @param rs
     */
    public static void close(ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(state, conn);
    }

    /**
     * 关闭statement对象和Connection对象
     * @param state
     * @param conn
     */
    public static void close( Statement state, Connection conn) {

        try {
            if (state != null) {
                state.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
    }

    /**
     * 关闭Connection 对象
     * @param conn
     */
    public static void close( Connection conn) {
//        try {
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        pool.close(conn);

    }




}
