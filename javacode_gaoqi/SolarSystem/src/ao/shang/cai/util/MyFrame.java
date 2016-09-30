package ao.shang.cai.util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 蔡尚澳 on 2016/7/13.
 */
public class MyFrame extends Frame {

    /**
     * 启动窗口
     */

    public void launchFrame(){  //GUI编程AWT,Swing等
        setSize(Contact.GAME_WIDTH, Contact.GAME_HEIGHT);
        setLocation(100, 100);
        setVisible(true);

        new MyFrame.PainThread().start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

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
}
