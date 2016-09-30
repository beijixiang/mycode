package cn.bjsxt.opp.testObject;

/**
 * Created by 蔡尚澳 on 2016/7/7.
 */
public class testObject {
    public static void main(String[] args) {
        Object object=new Object();
        Object object2=new Object();
        System.out.println(object.toString());

        System.out.println(object2.toString());
        System.out.println(object == object2);
        System.out.println(object.equals(object2));


        Mobile mobile=new Mobile();
        System.out.println(mobile.toString());

    }


}
