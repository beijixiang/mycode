package ao.shang.cai.test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 蔡尚澳 on 2016/7/13.
 */
public class GameFrame02 extends Frame {
    Image img= GameUtil.getImage("images/sun.jpg");

    public void launchFrame(){  //GUI编程AWT,Swing等
        setSize(500, 500);
        setLocation(100, 100);
        setVisible(true);

        new GameFrame02.PainThread().start();

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
    private double degree=3.14/3;  //移动的角度
    private double speed=10;
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, (int) x,(int) y, null);
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);
        if (speed > 0) {
            speed -= 0.05;
        } else {
            speed=0;
        }


        if (y < 30 || y > 500 - 30) {
            degree=-degree;
        }
        if (x > 500 - 30 || x < 0) {
            degree=Math.PI-degree;
        }




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
        GameFrame02 f = new GameFrame02();
        f.launchFrame();
    }
}
