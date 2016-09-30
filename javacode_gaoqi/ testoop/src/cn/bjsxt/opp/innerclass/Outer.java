package cn.bjsxt.opp.innerclass;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */
public class Outer {
    public static void main(String[] args) {
        Face face=new Face();
        Face.Nose nose=face.new Nose();
        nose.breath();

        Face.Ears ears=new Face.Ears();
        ears.listen();
    }
}

class Face{
    String type;
    String shape = "瓜子脸";
    static String color="红润";

    class Nose{
        String type;
        void breath(){
            System.out.println(Face.this.type);
            System.out.println("呼吸");
        }
    }

    static  class  Ears{
        void listen(){
            System.out.println(color);
            System.out.println("我在听");
        }
    }

}
