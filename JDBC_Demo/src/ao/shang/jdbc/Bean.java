package ao.shang.jdbc;

/**
 * Created by cai on 16-9-26.
 */
public class Bean {
    private String name;

    public Bean() {
    }

    public Bean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + this.name;
    }
}
