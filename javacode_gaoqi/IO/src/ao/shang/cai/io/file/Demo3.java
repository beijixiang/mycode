package ao.shang.cai.io.file;

import java.io.File;
import java.io.IOException;

/**
 *
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo3 {
    public static void main(String[] args) {

//        test1();
//        test2();
        try {
            test03();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件操作失败");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    *
    * 创建删除文件
    * */
    public static void test03() throws IOException, InterruptedException {
        String path = "H:/javacode_gaoqi/b.txt";
        File file = new File(path);

//        创建不存在文件
        if (!file.exists()) {
            boolean is=file.createNewFile();
            System.out.println(is ? "成功" : "失败");
        }
//      删除文件
        boolean flag = file.delete();
        System.out.println(flag?"成功":"失败");

//        创建临时文件

        File temp=File.createTempFile("aaa",".temp",new File("H:/javacode_gaoqi/"));

        Thread.sleep(10000);
        temp.delete();


    }

    /*
    * 判断读取信息
    *
    * */
    public static void test2(){
        String path = "H:/javacode_gaoqi/a.txt";
//        String path = "H:/javacode_gaoqi/b.java";
        File file = new File(path);
//        文件是否存在
        if (file.exists()) {
            System.out.println("文件存在");
        }

//        文件是否可读可写
        System.out.println("文件是否可写" +file.canWrite()+
                "文件是否可读"+file.canRead());
//        是文件还是文件夹
        if (file.isFile()) {
            System.out.println("是文件");
        } else if (file.isDirectory()) {
            System.out.println("是文件夹");
        }else {
            System.out.println("文件不存在");
        }

        System.out.println("是否为绝对路径"+file.isAbsolute());
//        不能读取文件夹的长度
        System.out.println("文件长度"+file.length());


    }

    /*
    * 建立联系
    *
    * */
    public static void test1(){

        String path = "H:/javacode_gaoqi/a.txt";
        File file = new File(path);
        System.out.println(file.getName());//返回文件名
        System.out.println(file.getPath()); //如果是绝对路径返回绝对路径，相对路径返回相对路径
        System.out.println(file.getAbsolutePath()); //返回绝对路径
        System.out.println(file.getParent());   //返回上一级

    }
}
