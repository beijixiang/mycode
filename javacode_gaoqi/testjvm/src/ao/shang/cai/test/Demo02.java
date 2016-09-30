package ao.shang.cai.test;

/**
 * classloader
 * Created by 蔡尚澳 on 2016/8/8.
 */
public class Demo02 {

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println(System.getProperty("java.class.path"));


        System.out.println("#######################");
        String a = "shangao";
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a);
    }
}
