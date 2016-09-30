package ao.shang.cai.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class Classroom {
    private String no;  //班号
    private List<Student> stus;
    private int score;

    public Classroom() {
        stus = new ArrayList<Student>();

    }

    public Classroom(String no) {
        this();
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
