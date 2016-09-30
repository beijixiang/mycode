package ao.shang.cai.sort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class NewsItemApp {
    public static void main(String[] args) {
        List<NewsItem> list = new ArrayList<>();
        list.add(new NewsItem("中国收复南海", new Date(), 100));
        list.add(new NewsItem("美国逃跑了", new Date(System.currentTimeMillis()-1000*60*60), 50));
        list.add(new NewsItem("菲律宾乖了", new Date(System.currentTimeMillis() + 1000 * 60 * 60), 200));

        System.out.println("排序前");
        System.out.println(list);
        System.out.println("排序后");
        Collections.sort(list);
        System.out.println(list);
    }
}
