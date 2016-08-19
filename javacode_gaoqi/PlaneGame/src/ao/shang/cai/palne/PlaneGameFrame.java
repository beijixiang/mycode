package ao.shang.cai.palne;

import ao.shang.cai.util.GameUtil;
import ao.shang.cai.util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by 蔡尚澳 on 2016/7/14.
 */
public class PlaneGameFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane plane = new Plane("images/plane.png", 50, 50);
    Date startTime;
    Date endTime;


    ArrayList bullets= new ArrayList();
    Explode bao ;
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        plane.draw(g);
        for (int i = 0; i <bullets.size() ; i++) {
            Bullet b = (Bullet) bullets.get(i);
            b.draw(g);
            boolean peng = plane.getRect().intersects(b.getRect());
            if (peng) {
                plane.setLive(false);

                if (bao==null) {
                    endTime = new Date();
                    bao = new Explode(plane.x, plane.y);

                }
                bao.draw(g);
                break;

            }
        }


        if (!plane.isLive()){

            int period =(int)((endTime.getTime() - startTime.getTime())/ 1000);
            printInfo("时间为：" + period + "秒", 20, g, 120, 260, Color.white);

            switch (period/10) {
                case 0:
                case 1:
                    printInfo("菜鸟",50,g,100,200,Color.white);
                    break;
                case 2:
                    printInfo("小鸟",50,g,100,200,Color.white);
                    break;
                case 3:
                    printInfo("大鸟",50,g,100,200,Color.yellow);
                    break;
                case 4:
                    printInfo("鸟王子",50,g,100,200,Color.yellow);
                    break;
                default:
                    printInfo("鸟人",50,g,100,200,Color.yellow);
                    break;
            }
        }
    }

    /**
     * 在窗口打印信息
     * @param str
     * @param size
     * @param g
     */

    public void printInfo(String str,int size,Graphics g,int x,int y,Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体", Font.BOLD, size);
        g.setFont(f);
        g.drawString(str,x,y);
    }

    @Override
    public void launchFrame() {
        super.launchFrame();
        //添加键盘监听器
        addKeyListener(new KeyMonitor());
        for (int i = 0; i < 50; i++) {
            Bullet b = new Bullet();
            bullets.add(b);

        }
        startTime = new Date();
    }

    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e );
        }
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }
}
