package ao.shang.cai.io.convert;

import java.io.*;

/**
 * 字节流转字符流
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class ConvertDemo2 {
    public static void main(String[] args) throws IOException {
//        指定字符集
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File("H:/javacode_gaoqi/Demo2.java")),"GBK")
        );

//        写出文件
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                new File("H:/javacode_gaoqi/Demo3.java")), "GBK")
        );


        String info = null;
        while (null != (info = br.readLine())) {
            bw.write(info);

        }
        bw.close();
        br.close();
    }
}
