package ao.shang.cai.net.url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class UrlDemo2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");

//        获取资源
        /**
        InputStream is = url.openStream();
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush, 0, len));
        }
         is.close;
         */

//        防止乱码
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("H:/baidu.html")));

        String msg = null;
        while ((msg = br.readLine()) != null) {
            bw.append(msg);
            bw.newLine();

        }

        bw.flush();
        br.close();
        bw.close();

    }
}
