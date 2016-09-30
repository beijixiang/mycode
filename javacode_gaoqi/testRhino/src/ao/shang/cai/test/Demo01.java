package ao.shang.cai.test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 *
 * 执行JavaScript脚本语言
 * Created by 蔡尚澳 on 2016/8/7.
 */
public class Demo01 {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {

//        脚本引擎调用
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

//        定义变量存储到上下文中
        engine.put("msg", "shangao is a good man!");
        String str = "var user={name:'shangao',age:18,school:['清华大学','北京大学']};";
        str += "print(user.name);";

//        执行脚本
        engine.eval(str);
        engine.eval("msg='tkk is a good school'");
        System.out.println(engine.get("msg"));
        System.out.println("####################################");

        //定义函数
        engine.eval("function add(a,b){var sum=a+b;return sum;}");
//        执行js函数
        Invocable invocable = (Invocable) engine;
        Object result1 = invocable.invokeFunction("add", new Object[]{19, 40});
        System.out.println(result1);

//      导入其他的Java包，使用其他包中的java

        String jscode = "var Arrays = Java.type(\"java.util.Arrays\");var list=Arrays.asList([\"北京大学\",\"清华大学\",\"厦门大学\"]);";
        engine.eval(jscode);

        List<String> list1 = (List<String>) engine.get("list");
        for (String temp : list1) {
            System.out.println(temp);

        }

//        执行一个js文件
        URL url = Demo01.class.getClassLoader().getResource("test.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();

    }

}
