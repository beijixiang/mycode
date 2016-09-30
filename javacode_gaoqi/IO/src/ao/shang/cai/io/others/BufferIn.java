package ao.shang.cai.io.others;

import java.io.*;

/**
 * 封装scanner
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class BufferIn {
    public static void main(String[] args) throws IOException {

        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("请输入。。。。。");
        System.out.println(br.readLine());

    }
}
