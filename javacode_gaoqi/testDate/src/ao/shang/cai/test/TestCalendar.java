package ao.shang.cai.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 蔡尚澳 on 2016/7/11.
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        c.set(2013, 2, 25, 8, 6, 8);
//        c.set(Calendar.YEAR, 2013);
//        c.set(Calendar.MONTH, 5);
//        c.set(Calendar.DATE,25);
//        c.setTime(new Date(1000));

        Date d=c.getTime();
        System.out.println(d);
        System.out.println(c.get(Calendar.YEAR));

        //测试日期计算
        c.add(Calendar.YEAR,30);
        System.out.println(c.get(Calendar.YEAR));

    }
}
