package ao.shang.cai.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式的基本使用
 * Created by 蔡尚澳 on 2016/8/14.
 */
public class Demo1 {
    public static void main(String[] args) {

//        创建正则表达式
        Pattern p = Pattern.compile("\\w+");
//        创建Matcher对象
        Matcher m = p.matcher("sdfs324&&234dfs2");
//        boolean yesorno = m.matches();  //整个字符串序列与表达式匹配
//        System.out.println(yesorno);

//        System.out.println(m.find());
//        System.out.println(m.group());
//        System.out.println(m.find());
//        System.out.println(m.group());


        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.group(0));
        }




    }
}
