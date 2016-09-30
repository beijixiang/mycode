package cn.bjsxt.opp.testencapsulation;

/**
 * Created by 蔡尚澳 on 2016/7/8.
 */
public class Test01 {
    private String str;

    protected void print(){
        String s=str;
        System.out.println("test01");
    }
}

class test001 extends Test01{

    public void pp(){
        super.print();
    }
    public void ppp(){
        Test01 test01=new Test01();
        test01.print();
    }


}
