package ao.shang.cai.testexception;

/**
 * Created by 蔡尚澳 on 2016/7/12.
 */
public class TestException {
    public static void main(String[] args) {

//        int i = 1 / 0;

        //空指针异常
        Computer c=null;
        if (c != null) {
            c.start();
        }

        //数字不合规异常
        String str = new String("1234ddd");
        Integer i = new Integer(str);
        System.out.println(i);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Computer {
    void start() {
        System.out.println("启动计算机");
    }
}
