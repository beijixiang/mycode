package ao.shang.cai.memento;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Emp {
    private String ename;
    private int age;
    private double salary;

//    进行备忘录操作
    public EmpMemento memento(){
        return new EmpMemento(this);
    }

    //    进行数据恢复
    public void recovery(EmpMemento memento) {
        this.age = memento.getAge();
        this.ename = memento.getEname();
        this.salary = memento.getSalary();

    }




    public Emp(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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
}
