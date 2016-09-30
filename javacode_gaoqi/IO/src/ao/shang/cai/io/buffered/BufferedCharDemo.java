package ao.shang.cai.io.buffered;

import java.io.*;

/**
 * 字符缓冲流
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class BufferedCharDemo {
    public static void main(String[] args) {

        //        建立联系
        File src = new File("H:/javacode_gaoqi/a.txt");
        File dest = new File("H:/javacode_gaoqi/f.txt");
//        选择流
        BufferedReader re = null;
        BufferedWriter wr = null;

        try {
            re = new BufferedReader(new FileReader(src));
            wr = new BufferedWriter(new FileWriter(dest));

//            使用新增方法
            String line = null;
            while (null != (line = re.readLine())) {

                wr.write(line);
                wr.newLine();
            }

            wr.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                wr.close();
                re.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件关闭失败");
            }
        }
    }

}
