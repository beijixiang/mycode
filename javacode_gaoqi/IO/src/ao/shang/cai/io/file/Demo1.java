package ao.shang.cai.io.file;

import java.io.File;

/**
 * File类
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo1 {
    public static void main(String[] args) {

        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

//        路径表示形式
        String path = "H:\\javacode_gaoqi\\a.txt";
        path = "E:" + File.separator + "javacode_gaoqi" + File.separator + "a.txt";
//        推荐使用
        path = "E:/javacode_gaoqi/a.txt";


    }
}
