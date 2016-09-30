package ao.shang.cai.io.byteIo;

import java.io.*;

/**
 * 文件的写入
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo2 {
    public static void main(String[] args) {

        //      建立联系
        File src = new File("H:/javacode_gaoqi/a.txt");
//      提升作用域
        OutputStream os = null;

        try {
//            关联
//            第二个参数选择ture表示追加，false表示覆盖
            os = new FileOutputStream(src,true);
            String str = "cai shang ao is very good \r\n";
            byte[] cars = str.getBytes();
            os.write(cars, 0, cars.length);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入失败");
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件关闭失败");
            }
        }

    }
}
