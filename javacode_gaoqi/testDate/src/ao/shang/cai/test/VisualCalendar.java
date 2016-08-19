package ao.shang.cai.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by 蔡尚澳 on 2016/7/11.
 */
public class VisualCalendar {
    public static void main(String[] args) {
        System.out.println("请输入日期（按照2013-5-20格式）：");

        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();


        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = df.parse(temp);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int oldDate = calendar.get(Calendar.DATE);
            calendar.set(Calendar.DATE, 1);
            System.out.println("日\t一\t二\t三\t四\t五\t六");

            for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
                System.out.print("\t");
            }

            int maxDate=calendar.getActualMaximum(Calendar.DATE);
            for (int i = 1; i < maxDate ; i++) {
                if (i == oldDate) {
                    System.out.print("*");
                }
                System.out.print(i+"\t");
                int w=calendar.get(Calendar.DAY_OF_WEEK);
                if (w==Calendar.SATURDAY) {
                    System.out.println();
                }

                calendar.add(Calendar.DATE,1);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
