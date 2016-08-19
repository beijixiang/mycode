package ao.shang.test;

import ao.shang.sorm.core.MySqlQuery;
import ao.shang.sorm.core.Query;
import ao.shang.sorm.core.QueryFactory;
import ao.shang.vo.EmpVO;

import java.util.List;

/**
 * 客户端调用测试类
 * Created by 蔡尚澳 on 2016/8/18.
 */
public class Test {
    public static void main(String[] args) {
        Query q = QueryFactory.creatQuery();
        String sql2="select e.id,e.empname,e.salary+e.bonus 'xinshui',e.age,d.dname 'deptName',d.address 'deptAddr' FROM emp e"+
                " JOIN dept d ON e.deptId=d.id ";
        List<EmpVO> list2 = q.queryRows(sql2, EmpVO.class,null);
        for (EmpVO emp : list2) {
            System.out.println(emp.getEmpname() + "--" + emp.getDeptAddr() + "---" + emp.getXinshui());
        }


    }
}
