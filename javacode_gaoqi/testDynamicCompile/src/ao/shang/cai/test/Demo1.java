package ao.shang.cai.test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 测试动态编译
 * Created by 蔡尚澳 on 2016/8/7.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "c:/myjava/Welcome.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");


        //通过调用runtime 执行类编译
//        Runtime run = Runtime.getRuntime();
//        Process process = run.exec("java -cp c:/myjava   Welcome ");
//
//        InputStream is = process.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        String info="";
//        while ((info = br.readLine()) != null) {
//            System.out.println(info);
//        }

        URL[] urls = new URL[]{new URL("file:/" + "c:/myjava/")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class c = loader.loadClass("Welcome");
        //调用main方法

        Method method = c.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[]{});


    }

}
