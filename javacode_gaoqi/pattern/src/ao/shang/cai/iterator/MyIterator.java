package ao.shang.cai.iterator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public interface MyIterator {
    //    游标指向第一个元素
    void first();

    //    游标指向最后一个元素
    void last();

    //    检查是否有下一个
    boolean hasNext();

    //  检测是否为第一个
    boolean isFirst();

    //  检测是否为最后一个
    boolean isLast();

    //  获取当前对象
    Object getCurrentObj();

    //    指向下一个
    void next();
}

