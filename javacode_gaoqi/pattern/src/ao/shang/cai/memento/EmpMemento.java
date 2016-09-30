package ao.shang.cai.memento;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class EmpMemento {
    private int age;
    private double salary;
    private String ename;


    public EmpMemento(Emp emp) {
        this.age = emp.getAge();
        this.ename = emp.getEname();
        this.salary = emp.getSalary();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
