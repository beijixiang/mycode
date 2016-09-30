package ao.shang.cai.observer;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class ObserverA  implements Obsever{

    private int myState;
    @Override
    public void update(Subject subject) {

        myState = ((ConcreteSubject) subject).getState();

    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
