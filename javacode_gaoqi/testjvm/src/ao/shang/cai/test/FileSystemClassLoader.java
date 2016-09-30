package ao.shang.cai.test;

import java.io.*;

/**
 * 自定义系统文件加载器
 * Created by 蔡尚澳 on 2016/8/8.
 */
public class FileSystemClassLoader extends ClassLoader {


    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass("name");   //确定该类是否已经被加载

//          确定是否已经加载该类，如果没有则进行交给父类加载，父类加载不了子类自己加载
        if (c != null) {
            return c;
        } else {
            ClassLoader parent = this.getParent();

            try {
                c = parent.loadClass(name); //委派给父类
            } catch (Exception e) {

            }

            if (c != null) {
                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String className) {

        String path = rootDir + "/" + className.replace('.', '/') + ".class";

        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);

            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (baos != null) {
                    baos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
