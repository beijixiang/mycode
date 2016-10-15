package ao.shang.jdbc.datasource;

import sun.misc.ExtensionInstallationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by cai on 16/10/4.
 */
public class MyDataSource {

    private static String url = "jdbc:mysql://localhost:3306/jdbc";
    private static String user = "root";
    private static String password = "shang123456";
    public LinkedList<Connection> connectionsPool = new LinkedList<>();

    private static int initCount = 5;
    private static int maxCount = 10;
    private int currentCount = 0;

    public MyDataSource() {

        for (int i = 0; i < 5; i++) {
            try {
                this.connectionsPool.addLast(createConnection());
                currentCount++;
            } catch (SQLException e) {
                throw new ExceptionInInitializerError(e);
            }
        }

    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
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

    public void free(Connection connection){
        this.connectionsPool.addLast(connection);
    }
}
