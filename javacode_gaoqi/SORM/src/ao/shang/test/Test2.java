package ao.shang.test;

import ao.shang.sorm.core.Query;
import ao.shang.sorm.core.QueryFactory;
import ao.shang.vo.EmpVO;

import java.util.List;

/**
 *测试连接池效率
 * Created by 蔡尚澳 on 2016/8/18.
 */
public class Test2 {

    public static void test01(){
        Query q = QueryFactory.creatQuery();
        String sql2="select e.id,e.empname,e.salary+e.bonus 'xinshui',e.age,d.dname 'deptName',d.address 'deptAddr' FROM emp e"+
                " JOIN dept d ON e.deptId=d.id ";
        List<EmpVO> list2 = q.queryRows(sql2, EmpVO.class,null);
        for (EmpVO emp : list2) {
            System.out.println(emp.getEmpname() + "--" + emp.getDeptAddr() + "---" + emp.getXinshui());
        }
    }
    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        for (int i = 0; i < 3000; i++) {
            test01();
        }
        long b = System.currentTimeMillis();
        System.out.println((b - a));    //不加连接池：33997ms 添加连接池以后4473ms
    }
}
