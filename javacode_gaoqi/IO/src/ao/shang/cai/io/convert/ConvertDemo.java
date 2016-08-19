package ao.shang.cai.io.convert;

import java.io.UnsupportedEncodingException;

/**
 * 字符的编码与解码
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class ConvertDemo {
    public static void main(String[] args) {
//        字节缺少

        String str = "中国";
        byte[] date = str.getBytes();
        System.out.println(new String(date,0,5));

    }

    /**
     * 字符解码与编码必须一样
     * @throws UnsupportedEncodingException
     */
    public static void test1() throws UnsupportedEncodingException {
        //        解码
        String str = "中国";
//        编码
        byte[] bytes = str.getBytes();
//        解码与编码字符集统一
        System.out.println(new String(bytes));
//
        bytes = str.getBytes("GBK");    //设定字符
//        不同一出现乱码
        System.out.println(new String(bytes));

//
        byte[] date = "中国".getBytes("GBK");
        System.out.println(new String(date,"GBK"));


    }
}
