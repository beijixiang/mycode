package ao.shang.cai.commons;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Closure 闭包  业务封装
 * <p>
 * Created by 蔡尚澳 on 2016/7/26.
 */
public class Demo3 {
    public static void main(String[] args) {
//        base();
//        ifclosure();
//        whileClosure();
        chainClosure();
    }
/*
*
*打折后满百再减20
*
* */
    public static void chainClosure(){
//        数据
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("javase", 120, true));
        list.add(new Goods("javaee", 100, false));
        list.add(new Goods("javame", 80, false));

//        如果打折则打9折
        Closure<Goods> discount = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                if (goods.isDiscount()) {
                    goods.setPrice(goods.getPrice() * 0.9);
                }

            }
        };
//        满100就减20
        Closure<Goods> struction = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                if (goods.getPrice() >= 100) {
                    goods.setPrice(goods.getPrice() - 20);
                }

            }
        };

//      二选一
        Closure closure = ChainedClosure.chainedClosure(discount,struction);
//        关联
        CollectionUtils.forAllDo(list, closure);
        for (Goods temp : list) {
            System.out.println(temp);
        }

    }

    /*
    *
    * 所以员工工资大于一万
    *
    * */
    public static void whileClosure() {

//      数据
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("hhhh", 10000));
        employees.add(new Employee("dddd", 20000));
        employees.add(new Employee("ffff", 5000));

        Predicate<Employee> pre = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee employee) {
                return employee.getSalary() < 10000;
            }
        };

        //        业务
        Closure<Employee> clos = new Closure<Employee>() {
            @Override
            public void execute(Employee employee) {
                employee.setSalary(employee.getSalary() * 1.2);
            }
        };
//      whileClosure 第三个参数为false 则为while 为true 则为do。。。while
        Closure<Employee> closure = WhileClosure.whileClosure(pre, clos, true);
//        工具类
        CollectionUtils.forAllDo(employees, closure);

//        迭代器遍历
        Iterator it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }

    }

    /*
    * 二选一
    *
    */
    public static void ifclosure() {
//        数据
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("javase", 120, true));
        list.add(new Goods("javaee", 100, false));
        list.add(new Goods("javame", 80, false));

//        如果打折则打9折
        Closure<Goods> discount = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                if (goods.isDiscount()) {
                    goods.setPrice(goods.getPrice() * 0.9);
                }

            }
        };
//        满100就减20
        Closure<Goods> struction = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                if (goods.getPrice() >= 100) {
                    goods.setPrice(goods.getPrice() - 20);
                }

            }
        };

        Predicate<Goods> pre = new Predicate<Goods>() {
            @Override
            public boolean evaluate(Goods goods) {
                return goods.isDiscount();
            }
        };
//      二选一
        Closure closure = IfClosure.ifClosure(pre, discount, struction);
//        关联
        CollectionUtils.forAllDo(list, closure);
        for (Goods temp : list) {
            System.out.println(temp);
        }

    }

    /*
    * 基本业务操作
    *
    */
    public static void base() {

//        业务
        Closure<Employee> clos = new Closure<Employee>() {
            @Override
            public void execute(Employee employee) {
                employee.setSalary(employee.getSalary() * 1.2);
            }
        };
//      数据
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("hhhh", 10000));
        employees.add(new Employee("dddd", 20000));
        employees.add(new Employee("ffff", 5000));
//        工具类
        CollectionUtils.forAllDo(employees, clos);

//        迭代器遍历
        Iterator it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }

    }
}
