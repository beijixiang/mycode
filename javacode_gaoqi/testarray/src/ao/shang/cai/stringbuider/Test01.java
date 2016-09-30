package ao.shang.cai.stringbuider;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class Test01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();//字符数组初始化长度为16
        StringBuilder sb2 = new StringBuilder(32);//字符数组初始长度为32
        StringBuilder sb3 = new StringBuilder("abc");//
        sb3.append("efg");
        sb3.append(true).append(321).append("随便");  //通过return this实现方法链

        System.out.println(sb3);
    }
}
