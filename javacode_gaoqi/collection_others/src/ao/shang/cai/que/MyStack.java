package ao.shang.cai.que;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 使用队列实现自定义堆栈
 * 1弹
 * 2压
 * 3获取
 *
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class MyStack<E> {
    //    容器
    private Deque<E> container = new ArrayDeque<E>();
    //    容量
    private int cap;

    public MyStack(int cap) {
        this.cap = cap;
    }

    public MyStack() {
    }

    //    压栈
    public boolean push(E e) {
        if (container.size() + 1 > cap) {
            return false;
        }
        return container.offerLast(e);
    }

    //  弹栈

    public E pop(){
        return container.pollLast();
    }

    // 获取

    public E peek(){
        return container.peekLast();
    }

    public int size(){
        return cap;
    }

}
