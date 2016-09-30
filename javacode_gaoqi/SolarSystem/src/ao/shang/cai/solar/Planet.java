package ao.shang.cai.solar;

import ao.shang.cai.util.GameUtil;

import java.awt.*;

/**
 * Created by 蔡尚澳 on 2016/7/13.
 */
public class Planet extends Start {

    //除了图片坐标，行星飞行需要长轴，短轴，飞行速度，飞行角度
    double longAxis;
    double shortAxis;
    double speed;
    double degree;
    Start center;

    boolean satellite;
    public void draw(Graphics g) {
        super.draw(g);
       move();
        if (!satellite){
            drawTrace(g);
        }

    }

    public void drawTrace(Graphics g){
        double ovelX,ovelY,ovelWidth,ovelHeight;
        ovelWidth=longAxis*2;
        ovelHeight = shortAxis * 2;
        ovelX = (center.x + center.width) - longAxis;
        ovelY = (center.y + center.height) - shortAxis;

        Color c = g.getColor();
        g.setColor(Color.blue);
        g.drawOval((int)ovelX,(int)ovelY,(int)ovelWidth,(int)ovelHeight);
        g.setColor(c);

    }

    public void move(){
        //沿着椭圆飞行
        this.x = (center.x+center.width/2) + longAxis * Math.cos(degree);
        this.y = (center.y+center.height/2) + shortAxis * Math.sin(degree);
        degree += speed;
    }

    public Planet( Start center,String imagepath,  double longAxis, double shortAxis,
                   double speed,boolean satellite) {
        this(center,imagepath,longAxis,shortAxis, speed);
        this.satellite=satellite;


    }

    public Planet( Start center,String imagepath,  double longAxis, double shortAxis,
                  double speed) {
        super(GameUtil.getImage(imagepath));
        this.center = center;
        this.x = center.x + longAxis;
        this.y = center.y;
        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;


    }

    public Planet(Image image, double x, double y) {
        super(image, x, y);
    }
}
