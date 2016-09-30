package ao.shang.cai.sort.innerType;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class Demo1 {
    public static void main(String[] args) {
        Integer a;  //使用基本数据类型比较
        Character ch;   //Unicode编码大小
        String str = "abc";
        String str2 = "abcd123";
        System.out.println(str.compareTo(str2));
        String str3 = "abc";
        String str4 = "aad";
        System.out.println(str3.compareTo(str4));
    }
}
