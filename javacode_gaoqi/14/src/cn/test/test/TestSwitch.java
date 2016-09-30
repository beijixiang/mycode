package cn.test.test;

/**
 * Created by 蔡尚澳 on 2016/5/9.
 * 测试switch语句
 */

public class TestSwitch {
    public static void main(String[] args) {
        double d=Math.random();
        int e=1+(int)(d*6);   //[0,4]
        System.out.println(e);

        if (e>3) {
            System.out.println("大数！");
            System.out.println("大数！！！！");
        }else {
            System.out.println("小数！！");
        }


        System.out.println("测试多选择结构");
        if (e==6){
            System.out.println("运气非常好");
        }else if (e==5){
            System.out.println("运气不错");
        }else if (e==4){
            System.out.println("运气还行吧");
        }else {     //1,2,3
            System.out.println("运气不好");
        }

        System.out.println("#####################################3");
        switch (e) {     //int,或者自动可以转为int类型的（byte,char,short).枚举//JDK7新特性

            case 6:
                System.out.println("运气非常好");
                break;  //一般在每个case之后都要加break 防止case穿透
            case 5:
                System.out.println("运气不错");
                break;
            case 4:
                System.out.println("运气还行吧");
                break;
            default:
                System.out.println("运气不好");
                break;

        }
        System.out.println("****************************************");

        char c='a';
        int rand=(int)(26*Math.random());
        char c2=(char)(c+rand);
        System.out.println(c2+": ");
        switch (c2){
            case 'a':
            case 'i':
            case 'e':
            case 'o':
            case 'u':
                System.out.println("原因");   break;
            case 'y':
            case 'w':
                System.out.println("半元音");  break;
            default:
                System.out.println("辅音");
        }

    }
}
