package ao.shang.cai.collection;

import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class Student {
    String name;
    Integer id;
    Date birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return id.equals(student.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
