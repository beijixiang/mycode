package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/8/8.
 */
public class Demo03 {

    public static void main(String[] args) throws ClassNotFoundException {

        FileSystemClassLoader loader = new FileSystemClassLoader("f:/myjava");
        FileSystemClassLoader loader1 = new FileSystemClassLoader("f:/myjava");

        Class<?> c = loader.loadClass("ao.shang.cai.bean.Emp");
        Class<?> c2 = loader.loadClass("ao.shang.cai.bean.Emp");
        Class<?> c3= loader1.loadClass("ao.shang.cai.bean.Emp");
        Class<?> c4 = loader1.loadClass("java.lang.String");
        Class<?> c5 = loader1.loadClass("ao.shang.cai.test.Demo01");


        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c5.getClassLoader());
        System.out.println(c4.getClassLoader());
    }
}
