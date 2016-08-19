package ao.shang.cai.propotype;

import java.io.Serializable;
import java.util.Date;

/**
 * 克隆羊
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Sheep implements Cloneable,Serializable {
    private String name;
    private Date birthday;

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

//    浅克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        return obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
