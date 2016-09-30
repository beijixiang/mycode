package ao.shang.cai.sort.col;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Person {
    //人名
    private final String name;
    //帅气指数
    private final int handsome;

    public Person() {
        name = null;
        handsome = 0;
    }

    public Person(String name, int handsome) {
        this.name = name;
        this.handsome = handsome;
    }

    public String getName() {
        return name;
    }



    public int getHandsome() {
        return handsome;
    }


    @Override
    public String toString() {
        return "名字 " + this.name + " 帅气指数 " + this.handsome + "\n";
    }
}
