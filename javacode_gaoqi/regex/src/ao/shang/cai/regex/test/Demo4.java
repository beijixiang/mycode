package ao.shang.cai.regex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式的分组表达式处理
 * Created by 蔡尚澳 on 2016/8/14.
 */
public class Demo4 {
    public static void main(String[] args) {

        String str = "a223b333c23";
        String[] arrs = str.split("\\d+");
        System.out.println(Arrays.toString(arrs));



    }
}
