package ao.shang.cai.collection;

import java.util.ArrayList;

/**
 * Created by 蔡尚澳 on 2016/7/10.
 */
public class MyArraryList {
    private Object[] values;

    private int size;

    public MyArraryList(){
        this(10);
    }

    public MyArraryList(int size){
        if (size < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        values = new Object[size];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int lastIndexOf(Object object) {
        if (object == null) {
            return -1;
        } else {
            for (int i = values.length-1; i >=0; i--)
                if (values[i]==object)
                    return i;
        }
        return -1;
    }

    public int indexOf(Object object) {
        if (object == null) {
                    return -1;
        } else {
            for (int i = 0; i < values.length; i++)
                if (values[i]==object)
                    return i;
        }
        return -1;
    }

    public Object set(int index, Object object) {
        rangeCheck(index);

        Object old = values[index];
        values[index] = object;
        return old;
    }

    public void add(Object object) {
        values[size]=object;
        size++;

        if (size>=values.length){
            int newCapacities=values.length * 2;
            Object[] newlist = new Object[newCapacities];
            for (int i = 0; i < values.length  ; i++) {
                newlist[i]=values[i];
            }

            values=newlist;
        }
    }

    public Object get(int index){
        rangeCheck(index);
        return values[index];
    }

    public void rangeCheck(int index){
        if (index < 0 || index > values.length - 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyArraryList list = new MyArraryList(2);
        list.add("dasda");
        list.add(new Human("shangao"));
        list.add("ddddd");
        list.add("dasdassdadas");
        list.add("dasdassdadas");
        list.add("dasdassdadas");
        list.add("dasdassdadas");
        list.add("dasdassdadas");

        Human h = (Human) list.get(1);


        System.out.println(h.getName());
        System.out.println(list.get(4));
        System.out.println(list.size());
    }



}
