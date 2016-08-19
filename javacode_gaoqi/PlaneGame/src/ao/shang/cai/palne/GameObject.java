package ao.shang.cai.palne;

import java.awt.*;

/**
 * Created by 蔡尚澳 on 2016/7/15.
 */
public class GameObject {
    double x, y;
    Image img;
    int width, height;
    int speed = 3;



    public Rectangle getRect(){
        return new Rectangle((int) x, (int) y, width, height);
    }

    public GameObject(double x, double y, Image img, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }
    public GameObject(){

    }
}
