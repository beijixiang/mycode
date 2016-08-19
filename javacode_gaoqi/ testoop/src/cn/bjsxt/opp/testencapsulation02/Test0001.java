package cn.bjsxt.opp.testencapsulation02;

import cn.bjsxt.opp.testencapsulation.Test01;

/**
 * Created by 蔡尚澳 on 2016/7/8.
 */
public class Test0001 extends Test01 {

    public void ttt(){
        super.print();
    }
    public static void main(String[] args) {
        Test0001 test0001=new Test0001();
        test0001.print();
    }
}
