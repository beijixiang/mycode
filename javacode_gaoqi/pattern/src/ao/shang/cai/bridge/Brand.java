package ao.shang.cai.bridge;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public interface Brand {
    void sale();
}

class Lenovo implements Brand {

    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand {

    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}

class shenzhou implements Brand {

    @Override
    public void sale() {
        System.out.println("销售神舟电脑");
    }
}