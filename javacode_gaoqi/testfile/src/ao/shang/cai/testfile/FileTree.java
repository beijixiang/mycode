package ao.shang.cai.testfile;

import java.io.File;

/**
 * Created by 蔡尚澳 on 2016/7/12.
 */
public class FileTree {
    public static void main(String[] args) {
        File f1 = new File("H:/javacode_gaoqi");
        printFile(f1,0);

    }

    static void printFile(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }

        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files=file.listFiles();
            for (File temp : files) {
                printFile(temp,level+1);
            }
        }
    }
}
