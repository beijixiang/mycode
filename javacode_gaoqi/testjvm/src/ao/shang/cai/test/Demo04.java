package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/8/9.
 */
public class Demo04 {

    public static void main(String[] args) throws ClassNotFoundException {
//        测试取反操作
//        int a = 3;
//        System.out.println(Integer.toBinaryString(a ^ 0xff));

//        未使用解密加载器
//        FileSystemClassLoader loader = new FileSystemClassLoader("f:/myjava/temp");
//
//        Class<?> c = loader.loadClass("Welcome");
//        System.out.println(c);

//      使用了解密加载器
        DecrptClassLoader loader = new DecrptClassLoader("f:/myjava/temp");

        Class<?> c = loader.loadClass("Welcome");
        System.out.println(c);

    }


}
