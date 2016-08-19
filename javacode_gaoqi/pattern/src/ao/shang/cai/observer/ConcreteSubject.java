package ao.shang.cai.observer;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class ConcreteSubject extends Subject {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObserver();
    }


}
