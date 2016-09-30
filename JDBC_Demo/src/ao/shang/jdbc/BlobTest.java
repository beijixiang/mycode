package ao.shang.jdbc;

import java.io.*;
import java.sql.*;

/**
 * Created by cai on 16-9-20.
 */
public class BlobTest {
    public static void main(String[] args) throws IOException, SQLException {

        read();
//        create();
    }

    public static void create() throws SQLException, IOException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        建立连接
        conn = jdbcUtils.getConnection();

//        创建语句
        String sql = "insert into blob_test(big_bit) values(?)";
        ps = conn.prepareStatement(sql);
        File file = new File("download.jpg");
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ps.setBinaryStream(1, in, file.length());
//        执行语句
        int i= ps.executeUpdate();

        System.out.println("i = " + i);
//        释放资源
        in.close();
        jdbcUtils.free(rs,ps,conn);
    }


    public static void read() throws SQLException, IOException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        建立连接
        conn = jdbcUtils.getConnection();
//        创建语句
        String sql = "select big_bit from blob_test";
        ps = conn.prepareStatement(sql);


//        执行语句
        rs = ps.executeQuery();

//        处理结果
        while (rs.next()) {
            File file = new File("download_bak.jpg");
//            Blob blob=rs.getBlob(1);
//            InputStream is = blob.getBinaryStream();
            InputStream is = rs.getBinaryStream(1);

            OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buff = new byte[1024];
            for (int i=0;(i=is.read(buff))>0;) {
                os.write(buff, 0, i);
            }
            os.close();
            is.close();

        }
//        释放资源

        jdbcUtils.free(rs,ps,conn);
    }

}
