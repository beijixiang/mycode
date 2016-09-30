package ao.shang.cai.commons;

/**
 *商品类
 * Created by 蔡尚澳 on 2016/7/26.
 */
public class Goods {
    private String name;
    private double price;
    private boolean discount;

    public Goods(String name, double price, boolean discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Goods() {
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

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "(商品名：" + this.name + ",价格：" + this.price + "是否打折：" + (discount ? "是" : "否");
    }

}
