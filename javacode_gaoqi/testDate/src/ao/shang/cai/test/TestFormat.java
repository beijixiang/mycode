package ao.shang.cai.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/7/11.
 */
public class TestFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(123456789);
        String str = df.format(date);
        System.out.println(str);
        System.out.println("#####################");
        String str2 = "2013-2-18";
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = df2.parse(str2);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
