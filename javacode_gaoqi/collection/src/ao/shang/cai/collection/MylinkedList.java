package ao.shang.cai.collection;

import java.util.LinkedList;

/**
 * Created by 蔡尚澳 on 2016/7/16.
 */
public class MylinkedList {
    private Node first;
    private Node last;
    private int size;

    public void add(Object obj){
        Node n = new Node();
        if (first == null) {
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
            last = n;
        }else {
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);
            last=n;
        }
        size++;

    }

    public int size(){
        return size;
    }

    public Node node(int index){
        Node temp = null;
        if (first != null) {
            if (index < (size >> 1)) {
                temp = first;
                for (int i = 0; i < index; i++) {
                    temp=temp.Next;
                }

            } else {
                temp = last;
                for (int i = size - 1; i > index; i--)
                    temp = temp.previous;
            }
        }
        return temp;

    }

    public Object get(int index) {
        Node temp=node(index);
        return temp.Obj;
    }

    public void remove(int index) {
        Node temp = node(index);
        if (temp != null) {
            Node up = temp.previous;
            Node down = temp.Next;
            up.Next = down;
            down.previous = up;
            size--;

        }


    }

    public void add(int index, Object obj) {
        Node temp = node(index);
        Node newNode = new Node();
        newNode.Obj = obj;
        if (temp!=null) {
            Node up = temp.previous;
            up.Next = newNode;
            newNode.previous = up;
            newNode.Next=temp;
            temp.previous = newNode;
        }
        size++;


    }

    public static void main(String[] args) {
        MylinkedList list=new MylinkedList();
        list.add("aaa");
        list.add("bbb");
//        list.add(1, "BBB");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
//        list.remove(1);
        System.out.println(list.get(2));
    }


}
