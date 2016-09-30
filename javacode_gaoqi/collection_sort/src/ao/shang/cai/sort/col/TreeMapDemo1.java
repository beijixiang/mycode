package ao.shang.cai.sort.col;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class TreeMapDemo1 {
    public static void main(String[] args) {
        Person p1 = new Person("你", 100);
        Person p2 = new Person("我", 1000);
        Person p3 = new Person("她", 500);
        Person p4 = new Person("他", 200);


        TreeMap<Person,String> persons = new TreeMap<Person,String>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getHandsome()-o2.getHandsome();
            }
        });
        persons.put(p1,"hehehe");
        persons.put(p2,"hehehe");
        persons.put(p3,"hehehe");
        persons.put(p4,"hehehe");

//        查看键
        Set<Person> persons1 = persons.keySet();
        System.out.println(persons1);
    }
}
