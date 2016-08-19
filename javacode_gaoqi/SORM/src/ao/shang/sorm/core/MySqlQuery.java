package ao.shang.sorm.core;

import ao.shang.po.Emp;
import ao.shang.sorm.bean.ColumnInfo;
import ao.shang.sorm.bean.TableInfo;
import ao.shang.sorm.utils.JDBCUtil;
import ao.shang.sorm.utils.ReflectUtil;
import ao.shang.vo.EmpVO;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 负责mysql查询
 * Created by 蔡尚澳 on 2016/8/17.
 */
public class MySqlQuery extends Query {

    public static void testDML(){
        Emp emp = new Emp();
        emp.setId(1);

        emp.setEmpname("lily");
        emp.setAge(18);
        emp.setBirthday(new Date(System.currentTimeMillis()));
        emp.setSalary(3000.0);

//        new MySqlQuery().delete(emp);
//        new MySqlQuery().insert(emp);
        new MySqlQuery().update(emp, new String[]{"age", "salary", "empname"});
    }

    public static void testQuery(){
        List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?"
                , Emp.class, new Object[]{10, 5000});
        for (Emp emp : list) {
            System.out.println(emp.getEmpname());
        }

        String sql2="select e.id,e.empname,e.salary+e.bonus 'xinshui',e.age,d.dname 'deptName',d.address 'deptAddr' FROM emp e"+
                " JOIN dept d ON e.deptId=d.id ";
        List<EmpVO> list2 = new MySqlQuery().queryRows(sql2, EmpVO.class,null);
        for (EmpVO emp : list2) {
            System.out.println(emp.getEmpname() + "--" + emp.getDeptAddr() + "---" + emp.getXinshui());
        }

    }

    public static void main(String[] args) {
        Object obj = new MySqlQuery().queryValue("select count(*) from emp where salary>?", new Object[]{1000});
//        Number obj = new MySqlQuery().queryNumber("select count(*) from emp where salary>?", new Object[]{1000});
        System.out.println(obj);

//        testQuery();
    }

    @Override
    public Object queryPagenate(int pageNum, int size) {
        return null;
    }
}
