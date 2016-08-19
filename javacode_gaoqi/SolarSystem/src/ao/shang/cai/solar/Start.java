package ao.shang.cai.solar;

import ao.shang.cai.util.GameUtil;

import java.awt.*;

/**
 * Created by 蔡尚澳 on 2016/7/13.
 */
public class Start {
    Image img;
    double x, y;
    double width, height;

    public void draw(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);
    }

    public Start() {

    }

    public Start(Image img) {
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public Start(Image img,double x,double y){
        this(img);
        this.x = x;
        this.y = y;

    }
    public Start(String imagepath,double x,double y){
        this(GameUtil.getImage(imagepath), x, y);
    }
}
