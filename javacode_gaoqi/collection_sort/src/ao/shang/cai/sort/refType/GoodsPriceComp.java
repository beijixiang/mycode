package ao.shang.cai.sort.refType;

import java.util.Comparator;

/**
 * 对比商品价格按升序排列
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class GoodsPriceComp implements Comparator<Goods> {

    @Override
    public int compare(Goods o1, Goods o2) {
        return o1.getPrice() - o2.getPrice() > 0 ? 1 : (o1.getPrice() == o2.getPrice() ? 0 : -1);
    }
}
