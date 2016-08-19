package ao.shang.cai.que;

/**
 * Created by 蔡尚澳 on 2016/7/22.
 */
public class Demo02 {
    public static void main(String[] args) {
        MyStack<String> backHistory = new MyStack<>(3);
        backHistory.push("www.baidu.com");
        backHistory.push("www.google.com");
        backHistory.push("www.bing.com");
        backHistory.push("www.sougou.com");

        System.out.println(backHistory.size());
        String item = null;
        while (null !=(item= backHistory.pop())) {
            System.out.println(item);
        }

    }
}
