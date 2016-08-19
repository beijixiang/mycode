package ao.shang.sorm.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 储存表结构的信息
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class TableInfo {

    /**
     * 表名
     */
    private String name;

    /**
     * 所有字段的信息
     */
    private Map<String, ColumnInfo> columns;

    /**
     * 唯一主键
     */
    private ColumnInfo onlyPriKey;

    private List<ColumnInfo> priKeys;

    public TableInfo(String name, List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns) {
        this.name = name;
        this.columns = columns;
        this.priKeys = priKeys;
    }

    public List<ColumnInfo> getPriKeys() {
        return priKeys;
    }

    public void setPriKeys(List<ColumnInfo> priKeys) {
        this.priKeys = priKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getOnlyPriKey() {
        return onlyPriKey;
    }

    public void setOnlyPriKey(ColumnInfo onlyPriKey) {
        this.onlyPriKey = onlyPriKey;
    }

    public TableInfo() {
    }

    public TableInfo(String name, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
        this.name = name;
        this.columns = columns;
        this.onlyPriKey = onlyPriKey;
    }
}
