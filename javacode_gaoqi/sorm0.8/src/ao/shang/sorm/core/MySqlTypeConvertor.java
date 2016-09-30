package ao.shang.sorm.core;

/**
 *
 * 数据库数据类型转为Java数据类型
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class MySqlTypeConvertor implements TypeConvertor {


    @Override
    public String databaseType2JavaType(String columnType) {

        if ("varchar".equalsIgnoreCase(columnType) || "varchar".equalsIgnoreCase(columnType)) {
            return "String";
        } else if ("int".equalsIgnoreCase(columnType)
                || "tinyint".equalsIgnoreCase(columnType)
                || "smallint".equalsIgnoreCase(columnType)
                || "integer".equalsIgnoreCase(columnType)) {
            return "Integer";
        } else if ("bigint".equalsIgnoreCase(columnType)) {
            return "Long";
        }else if ("double".equalsIgnoreCase(columnType)) {
            return "Double";
        }else if ("clob".equalsIgnoreCase(columnType)) {
            return "java.sql.Clob";
        }else if ("blob".equalsIgnoreCase(columnType)) {
            return "java.sql.Blob";
        }else if ("Time".equalsIgnoreCase(columnType)) {
            return "java.sql.Time";
        }else if ("Date".equalsIgnoreCase(columnType)) {
            return "java.sql.Date";
        }else if ("Timestamp".equalsIgnoreCase(columnType)) {
            return "java.sql.Timestamp";
        }

        return null;
    }

    @Override
    public String javaType2DatabaseType(String javaDataType) {
        return null;
    }
}
