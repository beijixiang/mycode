package ao.shang.sorm.utils;

import ao.shang.sorm.bean.ColumnInfo;
import ao.shang.sorm.bean.JavaFieldSetGet;
import ao.shang.sorm.bean.TableInfo;
import ao.shang.sorm.core.DBManager;
import ao.shang.sorm.core.MySqlTypeConvertor;
import ao.shang.sorm.core.TableContext;
import ao.shang.sorm.core.TypeConvertor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 封装类生成Java源文件的操作
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class JavaFileUtil {



    /**
     * 根据字段生成Java属性信息
     * @param column    字段信息
     * @param convertor 类型转换器
     * @return  Java属性以及setget方法
     */
    public static JavaFieldSetGet creatFieldSetGetSRC(ColumnInfo column, TypeConvertor convertor) {

        JavaFieldSetGet jfsg = new JavaFieldSetGet();

        String javaFieldType = convertor.databaseType2JavaType(column.getDataType());



        jfsg.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");

//        public Username getUsername(){return username}
//      生成get方法的源码信息
        StringBuilder getScr = new StringBuilder();
        getScr.append("\tpublic " + javaFieldType + " get" + StringUtil.firstChar2upperCace(column.getName()) + "(){\n");
        getScr.append("\t\treturn " + column.getName()+";\n");
        getScr.append("\t}\n");
        jfsg.setGetInfo(getScr.toString());

        //        public void setUsername(String username){this.username=username}
//      生成et方法的源码信息
        StringBuilder setScr = new StringBuilder();
        setScr.append("\tpublic void set" + StringUtil.firstChar2upperCace(column.getName()) + "(");
        setScr.append(javaFieldType + " " + column.getName() + "){\n");
        setScr.append("\t\tthis." + column.getName() + "=" + column.getName() + ";\n");
        setScr.append("\t}\n");
        jfsg.setSetInfo(setScr.toString());

        return jfsg;

    }


    /**
     * 生成Java源文件
     * @param tableInfo 表信息
     * @param convertor 数据类型转换器
     * @return  Java源码
     */
    public static String creatJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {


        Map<String, ColumnInfo> columus = tableInfo.getColumns();
        List<JavaFieldSetGet> javaFileds = new ArrayList<JavaFieldSetGet>();

        for (ColumnInfo c : columus.values()) {
            javaFileds.add(creatFieldSetGetSRC(c, convertor));
        }

        StringBuilder src = new StringBuilder();

//        生成package语句
        src.append("package " + DBManager.getConf().getPoPackage() + ";\n\n");

//        生成import语句
        src.append("import java.util.*;\n");
        src.append("import java.sql.*;\n\n");

//        生成类声明语句
        src.append("public class " + StringUtil.firstChar2upperCace(tableInfo.getName()) + "{\n");

//        生成属性声明语句
        for (JavaFieldSetGet f : javaFileds) {
            src.append(f.getFieldInfo());
        }
        src.append("\n\n");


//        生成set方法语句n
        for (JavaFieldSetGet f : javaFileds) {
            src.append(f.getSetInfo());
        }
//        生成get方法语句
        for (JavaFieldSetGet f : javaFileds) {
            src.append(f.getGetInfo());
        }
//        生成结束符

        src.append("}\n");
        return src.toString();
    }


    public static void createJavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {

        String src = creatJavaSrc(tableInfo, convertor);
        String srcpath = DBManager.getConf().getSrcpath()+"\\";
        String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "\\\\");

        File f = new File(srcpath + packagePath);

        if (!f.exists()) {
            f.mkdirs();
        }

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(f.getAbsolutePath() + "\\"
                    + StringUtil.firstChar2upperCace(tableInfo.getName()) + ".java"));
            bw.write(src);
            System.out.println("生成数据库对应的类" + StringUtil.firstChar2upperCace(tableInfo.getName()) + ".java");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null) {
                    bw.close();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {
//        ColumnInfo ci = new ColumnInfo("username", "vachar", 1);
//        JavaFieldSetGet f=creatFieldSetGetSRC(ci, new MySqlTypeConvertor());
//        System.out.println(f);
        Map<String, TableInfo> map = TableContext.tables;
        for (TableInfo t : map.values()) {
            createJavaPOFile(t, new MySqlTypeConvertor());
        }
    }


}
