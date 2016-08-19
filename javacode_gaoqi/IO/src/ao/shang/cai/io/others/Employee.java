package ao.shang.cai.io.others;

import java.io.Serializable;

/**
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class Employee implements Serializable {

    private transient String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
