package ao.shang.cai.strategy;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打八折");
        return standardPrice * 0.8;
    }
}
