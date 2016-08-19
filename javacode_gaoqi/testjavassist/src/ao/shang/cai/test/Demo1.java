package ao.shang.cai.test;

import javassist.*;

import java.io.IOException;

/**
 * 用javassist操作字节码
 * Created by 蔡尚澳 on 2016/8/7.
 */
public class Demo1 {

    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("ao.shang.cai.bean.Emp");

//        创建属性
        CtField f1 = CtField.make("private int empno;", cc);
        CtField f2 = CtField.make("private String ename;", cc);
        cc.addField(f1);
        cc.addField(f2);


//        创建方法
        CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
        CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

//        创建构造器
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
        constructor.setBody("{this.empno=empno;this.ename=ename;}");
        cc.addConstructor(constructor);

//        将上面写好的类写入c:/myjava
        cc.writeFile("c:/myjava");
        System.out.println("生成类！成功");
    }


}
