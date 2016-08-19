package ao.shang.cai;

/**
 * Created by 蔡尚澳 on 2016/5/9.
 * 测试JDK7中Switch新特性
 *
 */
public class TestSwitch02 {
    public static void main(String[] args) {
        String a="蔡尚澳";

        switch (a){ //JDK新特性，表达式结果可以是字符串！！！
            case "马士兵":
                System.out.println("输入马士兵");
                break;
            case "蔡尚澳":
                System.out.println("输入蔡尚澳");
                break;
            default:
                System.out.println("大家好");
                break;

        }
    }
}
