package ao.shang.cai.test.annotation;

/**
 * Created by 蔡尚澳 on 2016/8/5.
 */

@CsaTable(value = "tb_student")
public class CsaStudent {
    @CsaField(columnName = "sname", type = "int", length = 10)
    private String studentName;
    @CsaField(columnName = "age", type = "varchar", length = 3)
    private int age;
    @CsaField(columnName = "id", type = "int", length = 10)
    private int id;



    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
