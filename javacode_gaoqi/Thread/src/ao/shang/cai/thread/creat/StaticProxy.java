package ao.shang.cai.thread.creat;

/**
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class StaticProxy {
    public static void main(String[] args) {

        Marry you = new You();
        WeddingCompany wed = new WeddingCompany(you);
        wed.marry();
    }
}

interface Marry{
    void marry();

}

/**
 * 真实角色
 */
class You implements Marry{

    @Override
    public void marry() {
        System.out.println("you and gaoyuanyuan is marring");

    }
}

/**
 * 代理角色
 */
class WeddingCompany implements Marry {
    private Marry you;

    public WeddingCompany() {
    }

    public WeddingCompany(Marry you) {
        this.you = you;
    }


    public void before(){
        System.out.println("准备");
    }

    public void after(){
        System.out.println("闹洞房");
    }

    @Override

    public void marry() {
        you.marry();
    }
}