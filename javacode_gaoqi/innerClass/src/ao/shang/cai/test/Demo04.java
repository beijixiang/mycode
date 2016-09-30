package ao.shang.cai.test;

/**
 * Created by 蔡尚澳 on 2016/8/9.
 */
public class Demo04 {




}

class Outer04{

    /*final */int a = 3;

    public void test(){

//         方法内部类
        class Inner{
            int b = 10;
//            static int c = 20;    //不能存在静态变量

            void tt(){
                System.out.println(b);

            }
        }
    }

}
