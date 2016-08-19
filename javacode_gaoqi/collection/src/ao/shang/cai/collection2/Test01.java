package ao.shang.cai.collection2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class Test01 {
    public static void main(String[] args) {

        Employee e = new Employee(0301, "高琪", 3000, "项目部", "2007-06");
        Employee e2 = new Employee(0302, "马士兵", 3500, "教学部", "2006-06");
        Employee e3 = new Employee(0303, "裴新", 3550, "教学部", "2007-06");

        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(e);
        list.add(e2);
        list.add(e3);

        printEmpName(list);

    }


    public static void printEmpName(ArrayList<Employee> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }
}
