package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/7/11.
 */
public class Test02 {
    public static void main(String[] args) {
        Integer a=1000; //JDK5.0之后有自动装箱，编译器改进代码 Integer a=new Integer(1000)
        Integer b=2000;

        int c = b;  //编译器改进 int c=new Integer(1500).value
        System.out.println(c);

        Integer d=1234;
        Integer d2 = 1234;
        System.out.println(d == d2);
        System.out.println(d.equals(d2));

        Integer d3=-129;
        Integer d4=-129;    //[-128,127]之内的数依然按基本数据类型处理
        System.out.println(d3 == d4);
        System.out.println(d3.equals(d4));
    }
}
