package ao.shang.cai.gen02;

import java.io.Closeable;
import java.io.IOException;

/**
 * 泛型方法<> 返回签名
 * 只能访问对象信息，不能修改信息
 *
 *
 * Created by 蔡尚澳 on 2016/7/18.
 */
public class TestMethod {
    public static void main(String[] args) {

    }

    //泛型方法
    public static <T extends Closeable> void test(T... a) {

        for (T temp : a) {
            try {
                temp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
