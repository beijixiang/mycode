package ao.shang.cai.solar;

import ao.shang.cai.util.Contact;
import ao.shang.cai.util.GameUtil;
import ao.shang.cai.util.MyFrame;

import java.awt.*;

/**
 * 太阳系主窗口
 * Created by 蔡尚澳 on 2016/7/13.
 */
public class SolarFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");

    Start sun = new Start("images/sun.jpg", Contact.GAME_HEIGHT/2,Contact.GAME_WIDTH/2);
    Planet earth = new Planet(sun, "images/earth.jpg", 150, 100, 0.1);
    Planet mars = new Planet(sun, "images/Mars.jpg", 200, 150, 0.2);
    Planet moon = new Planet(earth, "images/moon.jpg", 30, 20, 0.3,true);
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        sun.draw(g);
        earth.draw(g);
        mars.draw(g);
        moon.draw(g);
    }

    public static void main(String[] args) {
        new SolarFrame().launchFrame();
    }

}
