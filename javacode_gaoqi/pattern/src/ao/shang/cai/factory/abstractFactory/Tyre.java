package ao.shang.cai.factory.abstractFactory;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public interface Tyre {
    void resolve();
}

class LuxuryTyre implements Tyre{
    @Override
    public void resolve() {
        System.out.println("磨损慢");
    }
}

class LowTyre implements Tyre{
    @Override
    public void resolve() {
        System.out.println("磨损快");
    }
}
