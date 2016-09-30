package ao.shang.cai.io.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 输出子孙级目录
 * Created by 蔡尚澳 on 2016/7/27.
 */
public class Demo5 {
    public static void main(String[] args) {
        String path = "H:/javacode_gaoqi/IO";
        File src = new File(path);
        printName(src);

//        打印所以盘符
        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
        for (File temp : roots) {
            printName(temp);
        }

    }

    public static void printName(File file) {
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        System.out.println(file.getAbsolutePath());

        if (file.isDirectory()) {
            for (File temp : file.listFiles()) {
//                printName(temp);
            }
        }
//        System.out.println(file.getName());
    }
}
