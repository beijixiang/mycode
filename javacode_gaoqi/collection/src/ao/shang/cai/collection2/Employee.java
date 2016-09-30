package ao.shang.cai.collection2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class Employee {
    private int id;
    private String name;
    private int salary;
    private String department;
    private Date hireData;


    public Employee(int id, String name,int salary, String department, String hireData ) {
        //javabean 实体类
        this.department = department;

        this.name = name;
        this.salary = salary;
        this.id = id;
        DateFormat format = new SimpleDateFormat("yyyy-MM");

        try {
            this.hireData = format.parse(hireData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHireData() {
        return hireData;
    }

    public void setHireData(Date hireData) {
        this.hireData = hireData;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
