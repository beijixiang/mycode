package ao.shang.cai.test;

import javassist.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *
 * javassist常用api
 * Created by 蔡尚澳 on 2016/8/8.
 */
public class Demo2 {

    /**
     * 测试类信息获取
     * @throws Exception
     */
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("ao.shang.cai.test.Emp"); //获取已经写好的类

        byte[] bytes = cc.toBytecode(); //转为字节码
        System.out.println(Arrays.toString(bytes));


        System.out.println(cc.getName());   //获得包名加；类名
        System.out.println(cc.getSimpleName()); //获得类名
        System.out.println(cc.getSuperclass()); //获得父类
        System.out.println(cc.getInterfaces()); //获得接口

    }

    /**
     * 测试产生新的方法
     * @throws Exception
     */
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("ao.shang.cai.test.Emp");

//        CtMethod m = CtMethod.make("public int add(int a,int b){return a+b;} ", cc);
        CtMethod m = new CtMethod(CtClass.intType, "add",
                new CtClass[]{CtClass.intType, CtClass.intType}, cc);
        m.setModifiers(Modifier.PUBLIC);    //设置修饰符
        m.setBody("{System.out.println(\"shangao is goog\");return $1+$2;}");   //设置方法体
        cc.addMethod(m);

//        通过反射调用类
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
        Object result = method.invoke(obj, 20, 20);
        System.out.println(result);

    }

    /**
     * 修改已有的方法
     *
     * @throws Exception
     */
    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("ao.shang.cai.test.Emp");

        CtMethod m = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        m.insertBefore("System.out.println($1);");
        m.insertBefore("System.out.println(\"start!!!\");");
        m.insertAt(19, "int b=3;System.out.println(\"b=\"+b);");
        m.insertAfter("System.out.println(\"end!!!!\");");

        //        通过反射调用类
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sayHello", int.class);
        method.invoke(obj, 20);
    }

    /**
     * 获取属性操作
     * @throws Exception
     */
    public static void test04() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("ao.shang.cai.test.Emp");

//        CtField f = CtField.make("private int salary;", cc);
        CtField f = new CtField(CtClass.intType, "salary", cc);
        f.setModifiers(Modifier.PRIVATE);
        cc.addField(f);

//        添加对应的set、get方法
        cc.addMethod(CtNewMethod.getter("getSalary", f));
        cc.addMethod(CtNewMethod.setter("setSalary", f));


    }

    /**
     * 构造器操作
     * @throws NotFoundException
     */
    public static void test05() throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("ao.shang.cai.test.Emp");

        CtConstructor[] cs = cc.getConstructors();
        for (CtConstructor c : cs) {
            System.out.println(c.getLongName());
        }

    }

    public static void test06() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("ao.shang.cai.test.Emp");

        Object[] all = cc.getAnnotations();
        Author author = (Author) all[0];
        String name = author.name();
        int year = author.year();

        System.out.println("name:" + name + "  year:" + year);
    }


    public static void main(String[] args) throws Exception {
        test06();
    }
}
