package ao.shang.jdbc;

import java.io.*;
import java.sql.*;

/**
 * Created by cai on 16-9-20.
 */

public class ClobTest {
    public static void main(String[] args) throws IOException, SQLException {
        read();
//    create();
    }

    public static void create() throws SQLException, IOException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        建立连接
        conn = jdbcUtils.getConnection();

//        创建语句
        String sql = "insert into clob_test(big_txt) values(?)";
        ps = conn.prepareStatement(sql);
        File file = new File("src/ao/shang/jdbc/jdbcUtils.java");
        Reader reader = new BufferedReader(new FileReader(file));
        ps.setCharacterStream(1, reader, file.length());
//        执行语句
        int i= ps.executeUpdate();

        System.out.println("i = " + i);
//        释放资源
        reader.close();
        jdbcUtils.free(rs,ps,conn);
    }


    public static void read() throws SQLException, IOException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        创建语句
        String sql = "select big_txt from clob_test";
        ps = conn.prepareStatement(sql);


//        执行语句
        rs = ps.executeQuery();

//        处理结果
        while (rs.next()) {
            File file = new File("jdbcUtils_bak.java");
            Clob clob=rs.getClob("big_txt");
            Reader reader = clob.getCharacterStream();
            Writer writer = new BufferedWriter(new FileWriter(file));
            char[] buff = new char[1024];
            for (int i=0;(i=reader.read(buff))>0;) {
                writer.write(buff, 0, i);
            }
            writer.close();
            reader.close();

        }
//        释放资源

        jdbcUtils.free(rs,ps,conn);
    }


}
