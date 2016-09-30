package ao.shang.cai.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件夹操作
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo4 {
    public static void main(String[] args) {
//      test01();

        String path = "H:/javacode_gaoqi/";
        File src = new File(path);
        System.out.println("=============文件名============");
        if (src.exists()&&src.isDirectory()) {//存在并且是文件夹
            String[] s = src.list();
            for (String temp : s) {
                System.out.println(temp);

            }
        }
        System.out.println("=============文件名 File形式============");
        if (src.exists()&&src.isDirectory()) {//存在并且是文件夹
            File[] s = src.listFiles();
            for (File temp : s) {
//                System.out.println(temp.getName());
                System.out.println(temp.getAbsolutePath());
            }
        }

        System.out.println("=============.java============");
//        命令设计模式
        File[] s = src.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(dir.getName());
                return new File(dir,name).isDirectory()&&name.endsWith(".java");
            }

        });
        for (File temp : s) {
//                System.out.println(temp.getName());
            System.out.println(temp.getAbsolutePath());
        }
    }



    public static void test01(){

        String path = "H:/javacode_gaoqi/test/pro/m";
        File src = new File(path);
//            src.mkdir();
        src.mkdirs();
    }
}
