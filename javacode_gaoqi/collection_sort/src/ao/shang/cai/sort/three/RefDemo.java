package ao.shang.cai.sort.three;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 引用
 * 强引用：gc运行时不会被回收
 * 软引用：gc运行时只要在jvm内存不够时回收
 * 弱引用：gc运行时立即回收
 * 虚引用：无引用
 * Created by 蔡尚澳 on 2016/7/23.
 */
public class RefDemo {
    public static void main(String[] args) {
        //        常量池字符串
        String str =new String( "hheh hehh  heheheh");
//        弱引用对象
        WeakReference<String> str2 = new WeakReference<String>(str);
        System.out.println("通知回收前"+str2.get());
//        断开引用
        str = null;
//        通知回收
        System.gc();
//        实行回收
        System.runFinalization();
        System.out.println("通知回收后"+str2.get());

    }

    public static void strongTest(){

//        常量池字符串，不会被回收
        String str = "hheh hehh  heheheh";
        WeakReference<String> str2 = new WeakReference<String>(str);
        System.out.println("通知回收前"+str2.get());
//        断开引用
        str = null;
//        通知回收
        System.gc();
//        实行回收
        System.runFinalization();
        System.out.println("通知回收后"+str2.get());

    }
}
