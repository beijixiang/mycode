package ao.shang.cai.factory.abstractFactory;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public interface Seat {
    void message();
}

class LuxurySeat implements Seat{

    @Override
    public void message() {
        System.out.println("可以自动按摩");
    }
}

class LowSeat implements Seat{

    @Override
    public void message() {
        System.out.println("不可以按摩");
    }
}
