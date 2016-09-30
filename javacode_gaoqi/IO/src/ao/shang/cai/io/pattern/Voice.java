package ao.shang.cai.io.pattern;

/**
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class Voice {
    private int voice = 10;

    public Voice(int voice) {
        this.voice = voice;
    }

    public Voice() {
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public void say() {

        System.out.println(voice);
    }
}
