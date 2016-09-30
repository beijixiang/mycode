package ao.shang.jdbc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cai on 16-9-21.
 */
public class DaoFactory {

    private static UserDao userDao = null;
    private static DaoFactory instance = new DaoFactory();

    private DaoFactory(){

        try {
            Properties properties = new Properties();
            InputStream is=DaoFactory.class.getClassLoader().
                    getResourceAsStream("daoconfig.properties");
            properties.load(is);
            String userDaoClass = properties.getProperty("UserDaoClass");
            Class clazz = Class.forName(userDaoClass);
            userDao = (UserDao) clazz.newInstance();

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DaoFactory getInstance(){
        return instance;
    }

    public UserDao getUserDao(){
        return userDao;
    }


}
