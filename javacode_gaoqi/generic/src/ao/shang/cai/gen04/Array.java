package ao.shang.cai.gen04;

/**
 * 没有泛型数组
 * 声明可以使用但是创建失败
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class Array {


    public static void main(String[] args) {

        Integer[] arr = new Integer[10];
//        Student<String>[] arr2 = new Student<String>[10];
        Student<?>[] arr2 = new Student[10];

        MyarrayList<String> ml = new MyarrayList<String>();
        ml.add(0, "dd");

        String elem = ml.getElem(0);
        System.out.println(elem);

    }
}

class MyarrayList<E> {

//    E[] cap2 = new E[10]; //没有泛型数组

    Object[] cap = new Object[10];

    public void add(int idx, E e) {
        cap[idx] = e;
    }

    public E[] getAll(){
        return (E[]) cap;
    }

    public E getElem(int index){
        return (E) cap[index];
    }

}