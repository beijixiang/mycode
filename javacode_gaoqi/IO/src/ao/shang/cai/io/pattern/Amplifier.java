package ao.shang.cai.io.pattern;

/**
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class Amplifier {
    private Voice voice;

    public Amplifier(Voice voice) {
        this.voice = voice;
    }

    public Amplifier() {
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public void say(){
        System.out.println(voice.getVoice() * 1000);
    }
}
