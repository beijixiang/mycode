package ao.shang.cai.composite;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public interface Component {
    void operation();

}

interface Leaf extends Component {

}

interface Composite extends Component {
    void add(Component c);

    void remove(Component c);

    Component getChild(int index);

}
