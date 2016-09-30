package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/8/9.
 */
public class Demo1 {

//    静态内部类
    private static class StaticNestedClass{

    }

//    成员内部类
    private class FiledInnerClass{

    }


    public void sayHello() {

//        方法内部内
        class localClass {

        }

//        匿名内部类
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

            }
        };


    }

}
