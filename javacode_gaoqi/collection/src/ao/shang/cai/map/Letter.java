package ao.shang.cai.map;

/**
 * Created by 蔡尚澳 on 2016/7/20.
 */
public class Letter {
    private String name;
    private int count;

    public Letter(String name, int col) {
        this.name = name;
        this.count = count;
    }

    public Letter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
