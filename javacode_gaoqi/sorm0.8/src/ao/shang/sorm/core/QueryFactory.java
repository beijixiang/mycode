package ao.shang.sorm.core;

/**
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class QueryFactory {

    private static Query prototypeObj;  //原型对象

    static {
        try {
            Class c = Class.forName(DBManager.getConf().getQueryClass());
            prototypeObj = (Query) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private QueryFactory(){

    }


    public static Query creatQuery() {
        try {
            return (Query) prototypeObj.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }

}



