package ao.shang.cai.collection;

/**
 * Created by 蔡尚澳 on 2016/7/16.
 */
public class MyArraylist {
    private Object[] elementsData;
    private int size;

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public MyArraylist(){
        this(10);
    }
    public MyArraylist(int initialCapcity){
        if (initialCapcity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementsData = new Object[initialCapcity];

    }

    public void add(Object obj){
        ensureCapacity();
        elementsData[size] = obj;
        size++;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementsData[index];
    }

    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementsData, index+1, elementsData, index,
                    numMoved);
        elementsData[--size] = null;

    }

    public void remove(Object obj){
        for (int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                remove(i);
            }
        }
    }

    public Object set(int index, Object obj) {
        rangeCheck(index);

        Object oldValue = elementsData[index];
        elementsData[index] = obj;
        return oldValue;
    }

    public void add(int index,Object obj){
        ensureCapacity();
        System.arraycopy(elementsData, index, elementsData, index + 1,
                size - index);
        elementsData[index] = obj;
        size++;
    }

    public void ensureCapacity(){
        if (size >= elementsData.length) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementsData,0,newArray,0,elementsData.length);
            elementsData = newArray;
        }
    }
    private void rangeCheck(int index){
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyArraylist list = new MyArraylist(3);
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        list.add("777");
        list.add("888");
        System.out.println(list.get(4));

    }

}
