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
public class Demo03 {


    public static void test01(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Emp emp = new Emp();

        try {
            ps = conn.prepareStatement("SELECT empname,salary,age FROM Emp WHERE id>?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();


            while (rs.next()) {
                emp.setEmpname(rs.getString(1));
                emp.setSalary(rs.getDouble(2));
                emp.setAge(rs.getInt(3));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }

        System.out.println(emp.getEmpname() + "--" + emp.getSalary() + "--" + emp.getAge());
    }

    public static void test02(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> rows = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT empname,salary,age FROM Emp WHERE id>?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();


            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpname(rs.getString(1));
                emp.setSalary(rs.getDouble(2));
                emp.setAge(rs.getInt(3));
                rows.add(emp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }

        for (Emp emp : rows) {
            System.out.println(emp.getEmpname() + "--" + emp.getSalary() + "--" + emp.getAge());
        }

    }



    public static void main(String[] args) {
        test02();

    }

}
