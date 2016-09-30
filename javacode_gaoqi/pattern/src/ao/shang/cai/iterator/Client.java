package ao.shang.cai.iterator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Client {
    public static void main(String[] args) {

        ConcreteMyAggregate aggregate = new ConcreteMyAggregate();
        aggregate.addObject("aaa");
        aggregate.addObject("bbb");
        aggregate.addObject("ccc");
        aggregate.addObject("ddd");

        MyIterator iterator = aggregate.creatIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }

    }
}
