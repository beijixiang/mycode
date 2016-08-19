package ao.shang.cai.testsorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试map  list<map>来封装一条记录
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class Demo02 {


    public static void test01(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Object> row = new HashMap<>();

        try {
            ps = conn.prepareStatement("SELECT empname,salary,age FROM Emp WHERE id>?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();


            while (rs.next()) {
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }

        for (String key :row.keySet()) {
            System.out.print(key +"---"+ row.get(key)+"\t");
        }
    }

    public static void test02(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<String, Object>> maps = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT empname,salary,age FROM Emp WHERE id>?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();


            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
                maps.add(row);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }

        for (Map<String, Object> row : maps) {
            for (String key : row.keySet()) {
                System.out.print(key + "---" + row.get(key) + "\t");
            }
            System.out.println();
        }

    }

    public static void test03(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String, Object>> maps = new HashMap<>();

        try {
            ps = conn.prepareStatement("SELECT empname,salary,age FROM Emp WHERE id>?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();


            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("empname", rs.getObject(1));
                row.put("salary", rs.getObject(2));
                row.put("age", rs.getObject(3));
                maps.put(rs.getString(1), row);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }

        for (String rows : maps.keySet()) {
            Map<String, Object> row = maps.get(rows);
            for (String key : row.keySet()) {
                System.out.print(key + "---" + row.get(key) + "\t");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        test03();

    }

}
