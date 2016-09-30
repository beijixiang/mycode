package ao.shang.cai.palne;

import ao.shang.cai.util.Contact;

import java.awt.*;

/**
 * Created by 蔡尚澳 on 2016/7/14.
 */
public class Bullet extends  GameObject{
    double degree;

    public Bullet(){
        degree = Math.PI * Math.random() * 2;
        y = Contact.GAME_HEIGHT / 2;
        x = Contact.GAME_WIDTH / 2;
        width=10;
        height=10;

    }

    public Rectangle getRect(){
        return new Rectangle((int) x, (int) y, width, height);
    }



    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,width,height);
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        if (y<30||y>Contact.GAME_HEIGHT-height) {
            degree = -degree;
        }
        if (x < 0 || x > Contact.GAME_WIDTH - width) {
            degree = Math.PI -degree;
        }

        g.setColor(c);
    }
}
