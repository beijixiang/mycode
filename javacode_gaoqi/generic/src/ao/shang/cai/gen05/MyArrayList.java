package ao.shang.cai.gen05;

/**
 *
 * hasNext
 * next
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class MyArrayList {
    String[] elem = {"a", "b", "c", "d", "e", "f", "g"};
    int size = elem.length;

    int cursor = -1;

    /**
     * 判断是否有下一个元素，有的话返回true
     * @return
     */
    public boolean hasNext() {

        return cursor + 1 < size;

    }

    /**
     * 获取下一个元素
     * @return
     */

    public String next(){
        cursor+=1;
        return elem[cursor];

    }

    public void remove(){
        //删除元素
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        while (list.hasNext()) {
            System.out.println(list.next());
        }
    }

}
