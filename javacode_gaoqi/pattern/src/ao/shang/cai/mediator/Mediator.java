package ao.shang.cai.mediator;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public interface Mediator {
    void register(String dname, Department department);

    void command(String dname);


}
