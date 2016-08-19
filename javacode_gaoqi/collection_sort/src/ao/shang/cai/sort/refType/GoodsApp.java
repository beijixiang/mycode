package ao.shang.cai.sort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class GoodsApp {
    public static void main(String[] args) {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("我的视频", 100, 400));
        list.add(new Goods("你的视频", 50, 500));
        list.add(new Goods("她的视频", 200, 600));

        //排序前
        System.out.println(list);
        //排序后
        Collections.sort(list, new GoodsPriceComp());
        System.out.println(list);

        //按收藏量排序
        Collections.sort(list, new GoodsFavComp());
        System.out.println(list);

    }
}
