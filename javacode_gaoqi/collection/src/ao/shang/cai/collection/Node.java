package ao.shang.cai.collection;

/**
 * Created by 蔡尚澳 on 2016/7/16.
 */
public class Node {
    Node previous;
    Object Obj;
    Node Next;

    public Node() {
    }

    public Node(Node previous, Object obj, Node next) {
        this.previous = previous;
        Obj = obj;
        Next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getObj() {
        return Obj;
    }

    public void setObj(Object obj) {
        Obj = obj;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }
}
