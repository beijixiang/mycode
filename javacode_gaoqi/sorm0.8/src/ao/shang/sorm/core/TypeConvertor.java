package ao.shang.sorm.core;

/**
 * Created by 蔡尚澳 on 2016/8/16.
 */
public interface TypeConvertor {

    /**
     * 将数据库数据类型转化为Java的数据类型
     * @param columnType    数据库字段的数据类型
     * @return  java的数据类型
     */
    public String databaseType2JavaType(String columnType);

    /**
     * 将Java的数据类型转化为数据库的数据类型
     * @param javaDataType  java 数据类型
     * @return  数据库的数据类型
     */
    public String javaType2DatabaseType(String javaDataType);

}
