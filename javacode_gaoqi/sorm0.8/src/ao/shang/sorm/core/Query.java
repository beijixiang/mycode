package ao.shang.sorm.core;

import ao.shang.sorm.bean.ColumnInfo;
import ao.shang.sorm.bean.TableInfo;
import ao.shang.sorm.utils.JDBCUtil;
import ao.shang.sorm.utils.ReflectUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责查询（对外提供服务的核心类）
 * @author 蔡尚澳
 * Created by 蔡尚澳 on 2016/8/16.
 */
public abstract class Query  implements Cloneable{


    public Object executeQueryTemplate(String sql, Object[] params, CallBack back) {
        Connection conn = DBManager.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            JDBCUtil.handleParams(ps, params);
            System.out.println(ps);
            rs = ps.executeQuery();

            return back.doExecute(conn, ps, rs);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBManager.close(rs, ps, conn);
        }

    }


    /**
     * 执行一个DML语句
     * @param sql   sql语句
     * @param params    参数
     * @return  sql语句影响的行数
     */
    public int executeDML(String sql,Object[] params) {
        Connection conn = DBManager.getConn();
        int count = 0;

        PreparedStatement ps = null;
        try {
            ps=conn.prepareStatement(sql);
            JDBCUtil.handleParams(ps, params);
            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(ps, conn);
        }
        System.out.println(sql);
        return count;
    }

    /**
     * 把一个对象存进数据中
     * @param obj
     */
    public void insert(Object obj){

        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.getName() + " (");
        int countNotNullField = 0;
        List<Object> params = new ArrayList<Object>();  //储存参数列表

        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            String fieldName = f.getName();
            Object fieldValue = ReflectUtil.invokeGet(fieldName, obj);

            if (fieldValue != null) {

                sql.append(fieldName + ",");
                countNotNullField++;
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length() - 1, ')');
        sql.append(" values (");
        for (int i = 0; i < countNotNullField; i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');
        executeDML(sql.toString(), params.toArray());
    }

    /**
     * 删除clazz类对应的表中的记录（指定主键值id得记录）
     * @param clazz 跟表对应的类对象
     * @param id    主键值id
     *
     */
    public void delete(Class clazz, Object id){

//        通过class对象找tableinfo
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);

//        获得唯一主键
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

        String sql = "delete from " + tableInfo.getName() + " where " + onlyPriKey.getName() + "=? ";

        executeDML(sql, new Object[]{id});

    }

    /**
     *删除对象在数据库中对应的记录
     * @param obj
     */
    public void delete(Object obj) {

        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

        Object priKeyValue=ReflectUtil.invokeGet(onlyPriKey.getName(), obj);
        delete(c, priKeyValue);


    }

    /**
     * 更新对象对应的记录，并且只更新指定字段的值
     * @param obj   所要更新的对象
     * @param fileNames 更新的属性列表
     * @return 更新所影响的行数
     */
    public int update(Object obj, String[] fileNames) {

        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        ColumnInfo priKey = tableInfo.getOnlyPriKey();
        StringBuilder sql = new StringBuilder("update " + tableInfo.getName() + " set ");
        List<Object> params = new ArrayList<Object>();  //储存参数列表


        for (String fname : fileNames) {
            Object fvalue = ReflectUtil.invokeGet(fname, obj);
            params.add(fvalue);
            sql.append(fname + "=?,");
        }
        sql.setCharAt(sql.length() - 1, ' ');
        sql.append(" where ");
        sql.append(priKey.getName() + "=?");

        params.add(ReflectUtil.invokeGet(priKey.getName(), obj));


        return executeDML(sql.toString(), params.toArray());
    }

    /**
     * 查询多行记录，并将每行记录封装到clazz指定的类中
     * @param sql   sql语句
     * @param clazz 封装javabean类的class对象
     * @param params    sql参数
     * @return  查询的结果
     *
     */
    public List queryRows(String sql, Class clazz, Object[] params){

        return (List) executeQueryTemplate(sql, params, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                List list = null;
                try {
                    ResultSetMetaData metaData = rs.getMetaData();
                    while (rs.next()) {
                        if (list == null) {
                            list = new ArrayList();
                        }

                        Object rowObj = clazz.newInstance();

    //                多列
                        for (int i = 0; i < metaData.getColumnCount(); i++) {
                            String columnName = metaData.getColumnLabel(i + 1);
                            Object clolumValue = rs.getObject(i + 1);

    //                    调用rowObj对象的get方法将column值传进去
                            ReflectUtil.invokeSet(rowObj, columnName, clolumValue);

                        }
                        list.add(rowObj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return list;
            }
        });
    }

    /**
     * 查询一行行记录，并将该行记录封装到clazz指定的类中
     * @param sql   sql语句
     * @param clazz 封装javabean类的class对象
     * @param params    sql参数
     * @return  查询的结果
     *
     */
    public Object queryUniqueRow(String sql, Class clazz, Object[] params){
        List list = queryRows(sql, clazz, params);

        return (list == null && list.size() > 0) ? null : list.get(0);
    }

    /**
     * 查询一行一列记录，并将该行记录封装到clazz指定的类中
     * @param sql   sql语句
     * @param params    sql参数
     * @return  查询的结果
     *
     */
    public Object queryValue(String sql, Object[] params){

        return executeQueryTemplate(sql, params, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                Object value = null;
                try {
                    while (rs.next()) {
                        value = rs.getObject(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return value;
            }
        });
    }

    /**
     * 查询一行一列记录，并将该行记录封装到clazz指定的类中
     * @param sql   sql语句
     * @param params    sql参数
     * @return  查询的数字
     *
     */
    public Number queryNumber(String sql, Object[] params){

        return (Number) queryValue(sql, params);
    }

    public abstract Object queryPagenate(int pageNum, int size);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
