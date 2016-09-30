package ao.shang.cai.test;

import java.io.*;

/**
 * Created by 蔡尚澳 on 2016/8/9.
 */
public class EncrptUtil {

    public static void main(String[] args) {
        EncrptUtil.encrpt("f:/myjava/Welcome.class","f:/myjava/temp/Welcome.class");
    }

    public static void encrpt(String src, String des) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(des);
            fis = new FileInputStream(src);

            int temp = -1;
            while ((temp = fis.read()) != -1) {
                fos.write(temp ^ 0xff);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                        fis.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
