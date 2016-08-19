package ao.shang.cai.map;

import java.util.*;

/**
 * 定义一个Student类，属性name 名字，班号 no，分数score
 * 将学生存入list容器中，求每个班级的总分以及平均分，并分别打印出来
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class MapDemo03 {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        exam(list);
        Map<String, Classroom> rooms = new HashMap<String, Classroom>();
        total(rooms,list);
//        打印总分和平均分
        printScore(rooms);


    }

    public static void printScore(Map<String, Classroom> entry){
        Set<Map.Entry<String, Classroom>> entryset = entry.entrySet();
        Iterator<Map.Entry<String, Classroom>> it = entryset.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Classroom> room = it.next();
            int arg=room.getValue().getScore()/room.getValue().getStus().size();
            System.out.println("班级"+room.getKey()+"总分:"+room.getValue().getScore()+"平均分"+arg);
        }

    }



    public static void total(Map<String, Classroom> rooms, List<Student> list) {
        for (Student stu : list) {
            String no = stu.getNo();
            int score = stu.getScore();
            if (null == rooms.get(no)) {
                Classroom room = new Classroom(no);
                rooms.put(no, room);
            }
            Classroom room = rooms.get(no);
            room.setScore(room.getScore() + score);
            room.getStus().add(stu);
        }
    }


    public static void exam(List<Student> stus) {
        stus.add(new Student("a", "001", 80));
        stus.add(new Student("b", "002", 80));
        stus.add(new Student("c", "003", 80));
        stus.add(new Student("d", "001", 80));
        stus.add(new Student("e", "002", 80));
    }

}
