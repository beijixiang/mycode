package ao.shang.cai.io.pattern;

/**
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class App {
    public static void main(String[] args) {
        Voice v = new Voice();
        v.say();
        Amplifier am = new Amplifier(v);
        am.say();
    }
}
