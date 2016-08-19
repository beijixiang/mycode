package ao.shang.cai.palne;

import ao.shang.cai.util.GameUtil;

import java.awt.*;

/**
 * 爆炸类
 * Created by 蔡尚澳 on 2016/7/15.
 */
public class Explode {
    double x, y;
    static Image[] images=new Image[16];
    int count;

    static {
        for (int i = 0; i < 16; i++) {
            images[i] = GameUtil.getImage("images/explode/e" + (i+1) + ".gif");
            images[i].getWidth(null);
        }
    }

    public void draw(Graphics g) {
        if (count <= 15) {
            g.drawImage(images[count], (int) x, (int) y, null);
            count++;
        }

    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
