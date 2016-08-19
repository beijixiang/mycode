package ao.shang.cai.gen04;

/**
 * 泛型的嵌套
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class Bjsxt<T> {
    T stu;
    public static void main(String[] args) {

        //泛型的嵌套
        Bjsxt<Student<String>> room = new Bjsxt<Student<String>>();
        //从外到内拆分
        room.stu = new Student<String>();
        Student<String> stu =room.stu ;
        String score = stu.score;
        System.out.println(score);

    }
}
