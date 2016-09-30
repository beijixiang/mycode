package ao.shang.cai.factory.abstractFactory;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public interface CarFactory {
    Engine CreatEngine();
    Tyre CreatTyre();
    Seat CreatSeat();

}

class LuxuryCarFactory implements CarFactory{


    @Override
    public Engine CreatEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Tyre CreatTyre() {
        return new LuxuryTyre();
    }

    @Override
    public Seat CreatSeat() {
        return new LuxurySeat();
    }
}

class LowCarFactory implements CarFactory{


    @Override
    public Engine CreatEngine() {
        return new LowEngine();
    }

    @Override
    public Tyre CreatTyre() {
        return new LowTyre();
    }

    @Override
    public Seat CreatSeat() {
        return new LowSeat();
    }
}