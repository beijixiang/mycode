package ao.shang.cai.sort.refType;

import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class NewsItem implements Comparable<NewsItem> {
    //标题
    private String title;
    //时间
    private Date time;
    //点击量
    private int hits;

    public NewsItem() {
    }

    public NewsItem(String title, Date time, int hits) {
        this.title = title;
        this.time = time;
        this.hits = hits;
    }

    @Override
    public int compareTo(NewsItem o) {
        int result = 0;
        //比较时间
        result=this.time.compareTo(o.getTime());

        if (result == 0) {//日期相同比较点击量
            result = this.hits - o.getHits();
            if (result == 0) {//点击量相同比较标题
                this.title.compareTo(o.getTitle());
            }
        }
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "标题  "+this.title+"  点击量  "+this.hits+"  日期  "+this.time+"\n";
    }
}
