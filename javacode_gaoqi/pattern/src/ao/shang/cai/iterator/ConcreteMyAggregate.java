package ao.shang.cai.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class ConcreteMyAggregate {

    private List<Object> list = new ArrayList<Object>();

    public void addObject(Object obj){
        this.list.add(obj);
    }

    public void removeObject(Object obj){
        this.list.remove(obj);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public MyIterator creatIterator(){
        return new ConcreteIterator();
    }

//    使用内部类实现迭代器
    private class ConcreteIterator implements MyIterator {
    //      游标
    private int cursor;

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void last() {
            cursor = list.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return cursor < (list.size()) ? true : false;
        }

        @Override
        public boolean isFirst() {
            return cursor == 0 ? true : false;
        }

        @Override
        public boolean isLast() {
            return cursor == (list.size() - 1) ? true : false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }

        @Override
        public void next() {
            cursor++;
        }
    }
}
