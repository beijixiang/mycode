package ao.shang.cai.test;

import java.util.Date;

/**
 * 测试Date类基本用法
 * Created by 蔡尚澳 on 2016/7/11.
 */
public class testDate {
    public static void main(String[] args) {
        Date date=new Date();
        long t=System.currentTimeMillis();
        System.out.println(t);
        Date d2 = new Date(1000);
        System.out.println(d2.toGMTString());   //不建议使用
        d2.setTime(345245465);
        System.out.println(d2.getTime());
        System.out.println(date.getTime()<d2.getTime());







    }
}
