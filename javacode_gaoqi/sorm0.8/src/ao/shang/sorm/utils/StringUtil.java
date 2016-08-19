package ao.shang.sorm.utils;

/**
 * 封装字符串常用的操作
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class StringUtil {

    /**
     * 将目标字符串转为第一个字母大写的字符串
     * @param str   目标字符串
     * @return  首字符大写的目标字符串
     */
    public static String firstChar2upperCace(String str){

        return str.toUpperCase().substring(0, 1) + str.substring(1);

    }

}
