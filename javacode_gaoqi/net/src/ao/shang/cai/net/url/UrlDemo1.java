package ao.shang.cai.net.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class UrlDemo1 {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=tack");
        System.out.println("协议" + url.getProtocol());
        System.out.println("域名" + url.getHost());
        System.out.println("端口" + url.getPort());
        System.out.println("资源" + url.getFile());
        System.out.println("相对路径" + url.getPath());
        System.out.println("锚" + url.getRef());
        System.out.println("资源" + url.getQuery());


        url = new URL("http://www.baidu.com/a/");
        url = new URL(url, "index.html");
        System.out.println(url.toString());


    }
}
