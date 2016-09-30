package ao.shang.jdbc.service;

import ao.shang.jdbc.dao.UserDao;
import ao.shang.jdbc.domain.User;

/**
 * Created by cai on 16-9-21.
 */
public class UserService {

    private UserDao userDao;

    public void regist(User user) {
        this.userDao.addUser(user);
    }
}
