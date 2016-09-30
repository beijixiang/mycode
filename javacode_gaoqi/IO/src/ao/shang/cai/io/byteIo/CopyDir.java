package ao.shang.cai.io.byteIo;

import java.io.File;
import java.io.IOException;

/**
 * 拷贝文件夹
 * Created by 蔡尚澳 on 2016/7/28.
 */
public class CopyDir {
    public static void main(String[] args) {
//        建立联系
        String srcPath = "H:/javacode_gaoqi/IO";
        String destPath = "H:/javacode_gaoqi/dir";
        try {
            FileUtil.copyDir(srcPath, destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyDir(String srcPath, String destPath) throws IOException {
        //        创建File对象
        File src = new File(srcPath);
        File dest = new File(destPath);
        copyDir(src, dest);
    }

    /**
     * 文件夹拷贝
     * @param src
     * @param dest
     */
    public static void copyDir(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            dest = new File(dest, src.getName());
            dest.mkdirs();
        }
        copyDirDetail(src, dest);
    }


    /**
     * 文件拷贝详情
     * @param src 源文件的file对象
     * @param dest 目标文件
     */
    public static void copyDirDetail(File src, File dest) throws IOException {
        if (src.isFile()) { //如果是文件
            try {
                FileUtil.copyFile(src,dest);
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        } else if (src.isDirectory()) { //如果是文件夹
//            确保文件夹存在
            dest.mkdirs();
//            获取下一级文件和目录
            for (File temp : src.listFiles()) {
                copyDirDetail(temp, new File(dest, temp.getName()));

            }
        }
    }
}
