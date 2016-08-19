package ao.shang.cai.gen01;

import javafx.beans.binding.ObjectExpression;

/**
 * Created by 蔡尚澳 on 2016/7/18.
 */
public class Student {
    private Object javase;
    private Object orical;

    public Student(Object javase, Object orical) {
        this.javase = javase;
        this.orical = orical;
    }

    public Student() {
    }

    public Object getJavase() {
        return javase;
    }

    public void setJavase(Object javase) {
        this.javase = javase;
    }

    public Object getOrical() {
        return orical;
    }

    public void setOrical(Object orical) {
        this.orical = orical;
    }
}
