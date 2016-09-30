package ao.shang.cai.flyweight;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Client {
    public static void main(String[] args) {

        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");

        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("=============增加外部状态===============");
        chess1.display(new Coordinate(3, 4));
        chess2.display(new Coordinate(6, 7));
    }
}
