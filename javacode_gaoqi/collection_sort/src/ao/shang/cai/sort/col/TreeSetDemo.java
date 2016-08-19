package ao.shang.cai.sort.col;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Person p1 = new Person("你", 100);
        Person p2 = new Person("我", 1000);
        Person p3 = new Person("她", 500);
        Person p4 = new Person("他", 200);


        TreeSet<Person> persons = new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getHandsome()-o2.getHandsome();
            }
        });
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println(persons);

        //Treeset排序是在添加时候进行排序，后期进行修改不影响原来排序
        //更改值
        /*
        p4.setHandsome(100);
        p4.setName("你");
        System.out.println(persons);
        */

    }
}
