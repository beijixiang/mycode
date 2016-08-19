package ao.shang.cai.commons;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * Transform 类型转换
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Demo02 {
    public static void main(String[] args) {

//        自定义
        System.out.println("============自定义转换=========");

//        判别式
        Predicate<Employee> islow=new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee employee) {
                return employee.getSalary() < 10000;
            }
        };

        Predicate<Employee> ishigh=new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee employee) {
                return employee.getSalary() >= 10000;
            }
        };
        Predicate[] pres = {islow, ishigh};

//        转换

        Transformer<Employee,Level> lowLevel=new Transformer<Employee, Level>() {
            @Override
            public Level transform(Employee employee) {
                return new Level(employee.getName(), "卖身中");
            }
        };

        Transformer<Employee,Level> highLevel=new Transformer<Employee, Level>() {
            @Override
            public Level transform(Employee employee) {
                return new Level(employee.getName(), "养身中");
            }
        };
        Transformer[] trans = {lowLevel,highLevel};

        Transformer switchForm = new SwitchTransformer(pres, trans, null);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("老马", 10000));
        employees.add(new Employee("老裴", 999));

        Collection<Level> levels = CollectionUtils.collect(employees, switchForm);
        Iterator<Level> levelit = levels.iterator();
        while (levelit.hasNext()) {
            System.out.println(levelit.next());
        }

    }


    /**
     * 内置类转换
     */
    public static void innerTrans(){

        System.out.println("内置类型转换，将长整型数转化为指定格式字符串");
        Transformer<Long, String> trans = new Transformer() {
            @Override
            public Object transform(Object o) {
                return new SimpleDateFormat("yyyy年MM月dd日").format(o);
            }

        };
//        加入数据
        List<Long> list = new ArrayList<Long>();
        list.add(10000000000000L);
        list.add(500000000000000000L);
//        工具类
        Collection<String> times = CollectionUtils.collect(list, trans);
        for (String time : times) {
            System.out.println(time);
        }
    }
}
