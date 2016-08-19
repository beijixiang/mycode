package ao.shang.cai.adapter;

/**
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class Client {


    public void test(Target t){
        t.handleRequest();
    }


    public static void main(String[] args) {

        Client c = new Client();

        Adaptee a = new Adaptee();

//        Target t = new Adapter();
        Target t = new Adapter2(a);

        c.test(t);

    }

}
