package ao.shang.cai.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

import java.util.Queue;

/**
 * 队列queue
 * Created by 蔡尚澳 on 2016/7/26.
 */
public class Demo05 {
    public static void main(String[] args) {
//        circular();
//        readOnly();
//        predicate();
    }

    /*
    *
    * 断言队列
    * */

    public static void predicate(){
        CircularFifoQueue<String> cir = new CircularFifoQueue<>(2);
        cir.add("a");
        cir.add("b");
        cir.add("c");
        Predicate<String> pre = NotNullPredicate.INSTANCE;
        Queue<String> queue = PredicatedQueue.predicatedQueue(cir, pre);
        queue.add(null);
    }

    /*
    * 只读队列
    *
    * */

    public static void readOnly(){
        CircularFifoQueue<String> cir = new CircularFifoQueue<>(2);
        cir.add("a");
        cir.add("b");
        cir.add("c");

        Queue<String> queue = UnmodifiableQueue.unmodifiableQueue(cir);
        queue.add("d");

    }

    /*
    * 循环队列
    * */
    public static void circular(){
        CircularFifoQueue<String> cir = new CircularFifoQueue<>(2);
        cir.add("a");
        cir.add("b");
        cir.add("c");
        for (int i = 0; i < cir.size(); i++) {
            System.out.println(cir.get(i));
        }
    }
}
