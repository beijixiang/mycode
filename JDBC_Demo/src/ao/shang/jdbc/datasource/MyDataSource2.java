package ao.shang.jdbc.datasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by cai on 16/10/4.
 */
public class MyDataSource2 implements DataSource {

    private static String url = "jdbc:mysql://localhost:3306/jdbc";
    private static String user = "root";
    private static String password = "shang123456";
    public LinkedList<Connection> connectionsPool = new LinkedList<>();

    private static int initCount = 1;
    private static int maxCount = 1;
    int currentCount = 0;

    public MyDataSource2() {

        for (int i = 0; i < initCount; i++) {
            try {
                this.connectionsPool.addLast(createConnection());
                currentCount++;
            } catch (SQLException e) {
                throw new ExceptionInInitializerError(e);
            }
        }

    }

    public Connection createConnection() throws SQLException {
        Connection realConn=DriverManager.getConnection(url, user, password);
//        MyConnection myConnection=new MyConnection(realConn,this);
//        return myConnection;
        MyConnectionHandler proxy=new MyConnectionHandler(this);
        return proxy.bind(realConn);
    }

    public Connection getConnection() throws SQLException {
        synchronized (connectionsPool) {
            if (this.connectionsPool.size() > 0) {
                return this.connectionsPool.removeFirst();
            }
            if (currentCount < maxCount) {
                currentCount++;
                return this.createConnection();
            }

            throw new SQLException("没有链接了");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    public void free(Connection connection){
        this.connectionsPool.addLast(connection);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
