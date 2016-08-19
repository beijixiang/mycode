package ao.shang.cai.io.others;

import java.io.*;
import java.util.Arrays;

/**
 * 对象序列化和反序列化
 * Created by 蔡尚澳 on 2016/7/29.
 */
public class ObjectDemo1 {
    public static void main(String[] args) {
        try {
            write("H:/javacode_gaoqi/obj.txt");
            read("H:/javacode_gaoqi/obj.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 反序列化
     * @param srcPath
     */
    public static void read(String srcPath) throws IOException, ClassNotFoundException {
//        建立联系
        File src = new File(srcPath);
//        读取对象
        //       创建流
        ObjectInputStream is = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)));
//        读取数据
        Object obj = is.readObject();
        if (obj instanceof Employee) {
            Employee em = (Employee) obj;
            System.out.println(em.getName());
            System.out.println(em.getSalary());
        }
        int[] arr = (int[]) is.readObject();
        System.out.println(Arrays.toString(arr));
//        关闭资源
        is.close();
    }

    /**
     * 序列化
     * @param destPath
     * @throws IOException
     */

    public static void write(String destPath) throws IOException {
//        建立联系
        File dest = new File(destPath);
//      创建雇员
        Employee em = new Employee("hehe", 10000);
        int[] arr = {1, 2, 3, 4, 5};

        //        选择流
        ObjectOutputStream dos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)));
//        数据写入  注意顺序
        dos.writeObject(em);
        dos.writeObject(arr);

        dos.flush();
        dos.close();

    }
}
