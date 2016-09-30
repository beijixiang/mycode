package cn.bjsxt.opp.test;

/**
 * Created by 蔡尚澳 on 2016/7/6.
 */
public class Point {
    double x,y,z;

    public Point(double _x,double _y,double _z){
        x=_x;
        y=_y;
        z=_z;
    }

    public void setX(double _x){
        x=_x;
    }
    public void setY(double _y){
        y=_y;
    }
    public void setZ(double _z){
        z = _z;
    }

    public double distance(Point p){
        return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z));
    }
    public static void main(String[] args) {
        Point p = new Point(4, 5, 6);
        Point p2=new Point(20,40,50);
        p.setX(5);
        System.out.println(p.x);
        System.out.println(p.distance(p2));
    }
}
