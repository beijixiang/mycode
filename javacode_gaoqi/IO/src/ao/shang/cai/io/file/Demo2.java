package ao.shang.cai.io.file;

import java.io.File;

/**
 * 绝对路径与相对路径
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo2 {
    public static void main(String[] args) {

//        相对路径
        String parentPath = "E:/javacode_gaoqi";
        String name = "a.txt";
        File file = new File(parentPath, name);
        file = new File(new File(parentPath), name);
//        输出
        System.out.println(file.getName());
        System.out.println(file.getPath());
//        绝对路径
        file = new File("E:/javacode_gaoqi/a.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());

//        没有盘符
        file = new File("a.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());

    }
}
