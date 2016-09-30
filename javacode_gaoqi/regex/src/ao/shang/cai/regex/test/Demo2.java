package ao.shang.cai.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式的分组表达式处理
 * Created by 蔡尚澳 on 2016/8/14.
 */
public class Demo2 {
    public static void main(String[] args) {

//        创建正则表达式
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
//        创建Matcher对象
        Matcher m = p.matcher("asd232**dfa232*sff33");


        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }




    }
}
