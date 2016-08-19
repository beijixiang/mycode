package ao.shang.cai.test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 定义一个游戏类窗口
 * Created by 蔡尚澳 on 2016/7/13.
 */
public class GameFrame extends Frame {

    Image img= GameUtil.getImage("images/sun.jpg");

    public void launchFrame(){  //GUI编程AWT,Swing等
        setSize(500, 500);
        setLocation(100, 100);
        setVisible(true);

        new PainThread().start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    /**
     * 画内容
     * @param g
     */
    private double x=100,y=100;
    private boolean left;
    private boolean up;
    @Override
    public void paint(Graphics g) {
        /*if (left) {
            x -= 3;
        } else {
            x += 3;
        }
        if (x > 500 - 30) {
            left = true;
        }
        if (x < 0) {
            left = false;
        }*/
        if (up) {
            y -= 3;
        } else {
            y += 3;
        }
        if (y > 500 - 30) {
            up = true;
        }
        if (y < 30) {
            up = false;
        }

        g.drawImage(img, (int) x,(int) y, null);

    }

    /**
     * 定义一个重画窗口的线程类
     */
    class PainThread extends Thread {
        public void run(){
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    public static void main(String[] args) {
        GameFrame f = new GameFrame();
        f.launchFrame();
    }
}
