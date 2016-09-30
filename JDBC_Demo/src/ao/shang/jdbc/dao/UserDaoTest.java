package ao.shang.jdbc.dao;

import ao.shang.jdbc.dao.impl.UserDaojdbcimpl;
import ao.shang.jdbc.domain.User;

import java.util.Date;


/**
 * Created by cai on 16-9-21.
 */
public class UserDaoTest {

    public static void main(String[] args) {

        UserDao dao = DaoFactory.getInstance().getUserDao();
        User user = new User();
        user.setName("laowang");
        user.setBirthday(new Date());
        user.setMoney(1000.0f);
        dao.addUser(user);
        System.out.println(user.getId());


//        User u = dao.findUser("laowang", null);
//
//        User user1 = dao.getUser(8);
//        user1.setMoney(40000.0f);
//        dao.update(user1);

//        User u1 = dao.getUser(8);
//        dao.delete(u1);

    }
}
