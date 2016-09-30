package ao.shang.sorm.bean;

/**
 * Created by 蔡尚澳 on 2016/8/17.
 */
public class JavaFieldSetGet {

    /**
     * 属性的源码信息
     */
    private String FieldInfo;
    /**
     * get方法的源码
     */
    private String SetInfo;
    /**
     * set方法的源码信息
     */
    private String GetInfo;

    @Override
    public String toString() {
        System.out.println(getFieldInfo());
        System.out.println(getSetInfo());
        System.out.println(getGetInfo());
        return super.toString();
    }

    public String getFieldInfo() {
        return FieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        FieldInfo = fieldInfo;
    }

    public String getSetInfo() {
        return SetInfo;
    }

    public void setSetInfo(String setInfo) {
        SetInfo = setInfo;
    }

    public String getGetInfo() {
        return GetInfo;
    }

    public void setGetInfo(String getInfo) {
        GetInfo = getInfo;
    }

    public JavaFieldSetGet() {
    }

    public JavaFieldSetGet(String fieldInfo, String setInfo, String getInfo) {
        FieldInfo = fieldInfo;
        SetInfo = setInfo;
        GetInfo = getInfo;
    }
}
