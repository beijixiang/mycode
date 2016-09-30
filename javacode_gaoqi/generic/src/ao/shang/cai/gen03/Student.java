package ao.shang.cai.gen03;

/**
 * Created by 蔡尚澳 on 2016/7/18.
 */
public class Student<T> {
    private T javase;
    private T oracle;



    public T getOracle() {
        return oracle;
    }

    public void setOracle(T oracle) {
        this.oracle = oracle;
    }

    public T getJavase() {
        return javase;
    }

    public void setJavase(T javase) {
        this.javase = javase;
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setJavase("dfgsdf");

       test01(stu);
        test02(stu);
    }

    public static void test01(Student<Object> s) {

    }

    public static void test02(Student<?> s) {

    }
}
