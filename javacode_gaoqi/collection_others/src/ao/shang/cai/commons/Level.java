package ao.shang.cai.commons;

/**
 * Created by 蔡尚澳 on 2016/7/25.
 */
public class Level {
    private String name;
    private String level;

    public Level(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public Level() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "（码农："+this.name+"水平:"+this.level+")";
    }
}
