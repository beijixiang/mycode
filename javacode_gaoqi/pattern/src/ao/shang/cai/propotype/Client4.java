package ao.shang.cai.propotype;

/**
 * Created by 蔡尚澳 on 2016/8/11.
 */
public class Client4 {

    public static void testNew(int size) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            Laptop l2 = new Laptop();
        }
        long end = System.currentTimeMillis();
        System.out.println("new所花费时间为:" + (end - start));
    }

    public static void testClone(int size) throws CloneNotSupportedException {
        long start = System.currentTimeMillis();
        Laptop l1= new Laptop();
        for (int i = 0; i < size; i++) {
            Laptop l2 = (Laptop) l1.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("克隆所花费时间为:" + (end - start));

    }


    public static void main(String[] args) throws CloneNotSupportedException {

        testNew(1000);
        testClone(1000);


    }

}

class Laptop implements Cloneable{

    public Laptop(){

        try {
            Thread.sleep(10); //模拟创建对象延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();

        return object;
    }
}
