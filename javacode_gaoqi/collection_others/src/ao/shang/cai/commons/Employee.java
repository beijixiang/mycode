package ao.shang.cai.commons;

/**
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Employee {
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "（程序员：" + this.name + ",工资：" + this.salary;
    }
}
