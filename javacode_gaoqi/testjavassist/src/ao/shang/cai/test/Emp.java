package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/8/7.
 */

@Author(name = "gaoqi", year = 2016)
public class Emp {
    private String ename;
    private int empno;

    public Emp() {
    }

    public Emp(String ename, int empno) {
        this.ename = ename;
        this.empno = empno;
    }

    public void sayHello(int a) {
        System.out.println("say Hello" + a);

    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }
}
