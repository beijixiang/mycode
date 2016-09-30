package ao.shang.cai.regex.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 写出网络爬虫的核心
 * Created by 蔡尚澳 on 2016/8/14.
 */
public class WebSpiderCore {

    /**
     * 获取网页内容
     * @param urlStr 网页地址
     * @param charset   网页编码
     * @return  网页内容
     */
    public static String getURLContent(String urlStr,String charset){

        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));

            String temp = "";
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static List<String> getMatcherSubstrs(String destStr, String regexStr) {


//        Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");    //获取超链接的整个内容
        Pattern p = Pattern.compile(regexStr);
        Matcher m = p.matcher(destStr);

        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }

    public static void main(String[] args) {

        String destStr = getURLContent("http://www.163.com", "gbk");

        List<String> list = getMatcherSubstrs(destStr, "href=\"([\\w\\s/.:]+?)\"");

        for (String temp : list) {
            System.out.println(temp);
        }

    }
}
