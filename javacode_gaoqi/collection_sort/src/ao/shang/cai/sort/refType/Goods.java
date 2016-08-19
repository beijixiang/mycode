package ao.shang.cai.sort.refType;

/**
 * 商品实体类
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Goods {
    //      商品名称
    private String name;
    //    商品价格
    private double price;
    //    商品收藏量
    private int fav;

    public Goods() {
    }

    public Goods(String name, double price, int fav) {
        this.name = name;
        this.price = price;
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    @Override
    public String toString() {
        return "商品名称 " + this.name + " 收藏量 " + this.fav + " 商品价格 " + this.price+"\n";
    }

}
