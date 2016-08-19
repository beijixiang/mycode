package ao.shang.cai.observer2;

import java.util.Observable;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class ConcreteSubject extends Observable {

    private int state;

    public void set(int state){

        this.state = state;
        setChanged();
        notifyObservers(state);

    }

    public int getState() {
        return state;
    }

}
