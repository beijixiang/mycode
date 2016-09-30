package ao.shang.cai.test.bean;

/**
 * Created by 蔡尚澳 on 2016/8/6.
 */
public class User {

    private int id;
    private String uname;
    private int age;

    public User() {
    }

    public User(int id, int age, String uname) {
        this.id = id;
        this.uname = uname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
