package ao.shang.cai.palne;

import ao.shang.cai.util.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by 蔡尚澳 on 2016/7/14.
 */
public class Plane  extends GameObject{

    private boolean left,right,up,down;
    private boolean live = true;

    public void draw(Graphics g){
        if (live) {
            g.drawImage(img, (int)x,(int) y, null);
            move();
        }

    }


    public void move(){
        if (left) {
            x-=10;
        }
        if (right) {
            x+=10;
        }
        if (up) {
            y+=10;
        }
        if (down) {
            y-=10;
        }
    }

    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()) {
            case 37:
                left=true;
                break;
            case 38:
                down=true;
                break;
            case 39:
                right=true;
                break;
            case 40:
                up=true;
                break;
        }
    }

    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()) {
            case 37:
                left=false;
                break;
            case 38:
                down=false;
                break;
            case 39:
                right=false;
                break;
            case 40:
                up=false;
                break;
        }
    }

    public Plane(String imgpath, double x,  double y) {
        super();
        this.x = x;
        this.img = GameUtil.getImage(imgpath);
        this.y = y;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }


    public Plane(){

    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
