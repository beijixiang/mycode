package cn.bjsxt.opp.testInterface;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public interface InterfaceA {
    void aaa();
}

interface InterfaceB {
    void bbb();
}

interface InterfaceC extends InterfaceA,InterfaceB {
    void ccc();
}

class TestClass implements InterfaceC{

    @Override
    public void ccc() {

    }

    @Override
    public void aaa() {

    }

    @Override
    public void bbb() {

    }
}