package ao.shang.cai.memento;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Client {
    public static void main(String[] args) {

        CareTaker taker = new CareTaker();

        Emp emp = new Emp("尚澳", 18, 400);
        System.out.println("第一次打印，名字：" + emp.getEname() + ",工资："
                + emp.getSalary() + ",年龄：" + emp.getAge());

        taker.setMemento(emp.memento());    //备忘一次

        emp.setAge(49);
        emp.setEname("hjje");
        emp.setSalary(50000);
        System.out.println("第二次打印，名字：" + emp.getEname() + ",工资："
                + emp.getSalary() + ",年龄：" + emp.getAge());

        emp.recovery(taker.getMemento());
        System.out.println("第三次打印，名字：" + emp.getEname() + ",工资："
                + emp.getSalary() + ",年龄：" + emp.getAge());


    }
}
