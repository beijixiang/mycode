package ao.shang.cai.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Subject {
    protected List<Obsever> list = new ArrayList<>();

    public void register(Obsever obsever) {
        list.add(obsever);
    }

    public void remove(Obsever observer) {
        list.remove(observer);
    }

    public void notifyAllObserver() {
        for (Obsever temp : list) {
            temp.update(this);

        }

    }


}
