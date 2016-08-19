package ao.shang.cai.gen02;

/**
 * Created by 蔡尚澳 on 2016/7/18.
 */
public class Student<T1, T2> {
    private T1 javase;
    private T2 oracle;



    public T2 getOracle() {
        return oracle;
    }

    public void setOracle(T2 oracle) {
        this.oracle = oracle;
    }

    public T1 getJavase() {
        return javase;
    }

    public void setJavase(T1 javase) {
        this.javase = javase;
    }

    public static void main(String[] args) {
        Student<String, Integer> stu = new Student<String, Integer>();
        stu.setJavase("优秀");
        stu.setOracle(88);

        int it = stu.getOracle();

    }
}
