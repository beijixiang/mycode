package ao.shang.cai.bridge;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Computer2 {
    protected Brand brand;

    public Computer2(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        this.brand.sale();
    }
}

class Desktop2 extends Computer2 {

    public Desktop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式电脑");
    }
}


class Laptop2 extends Computer2 {

    public Laptop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式电脑");
    }
}


class Pad2 extends Computer2 {

    public Pad2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式电脑");
    }
}