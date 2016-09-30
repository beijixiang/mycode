package ao.shang.cai.flyweight;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public interface ChessFlyWeight {
    void setColor(String color);
    String getColor();
    void display(Coordinate coordinate);
}


class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        super();
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色为");
        System.out.println("棋子坐标为X:"+coordinate.getX()+"------------Y:"+coordinate.getY());
    }
}

