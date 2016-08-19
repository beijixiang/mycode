package ao.shang.sorm.bean;

/**
 * 管理配置信息
 * Created by 蔡尚澳 on 2016/8/16.
 */
public class Configuration {

    /**
     * 数据库驱动
     */
    private String driver;
    /**
     * jdbc的url
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String user;
    /**
     * 数据库的密码
     */
    private String pwd;
    /**
     * 正在使用哪个数据库
     */
    private String usingDB;
    /**
     * 项目源码路径
     */
    private String srcpath;
    /**
     * 扫描生成java类的包
     */
    private String poPackage;
    /**
     * 项目使用的查询类是哪一类
     */
    private String queryClass;

    /**
     * 连接池中的最大数
     */
    private int poolMaxSize;
    /**
     * 连接池中的最小数
     */
    private int poolMinSize;

    public String getQueryClass() {
        return queryClass;
    }

    public int getPoolMaxSize() {
        return poolMaxSize;
    }

    public void setPoolMaxSize(int poolMaxSize) {
        this.poolMaxSize = poolMaxSize;
    }

    public int getPoolMinSize() {
        return poolMinSize;
    }

    public void setPoolMinSize(int poolMinSize) {
        this.poolMinSize = poolMinSize;
    }

    public void setQueryClass(String queryClass) {
        this.queryClass = queryClass;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsingDB() {
        return usingDB;
    }

    public void setUsingDB(String usingDB) {
        this.usingDB = usingDB;
    }

    public String getSrcpath() {
        return srcpath;
    }

    public void setSrcpath(String srcpath) {
        this.srcpath = srcpath;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
    }

    public Configuration() {
    }

    public Configuration(String driver, String url, String user, String pwd,
                         String usingDB, String srcpath, String poPackage) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        this.usingDB = usingDB;
        this.srcpath = srcpath;
        this.poPackage = poPackage;
    }
}
