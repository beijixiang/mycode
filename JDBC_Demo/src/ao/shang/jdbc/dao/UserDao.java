package ao.shang.jdbc.dao;

import ao.shang.jdbc.domain.User;

/**
 * Created by cai on 16-9-20.
 */
public interface UserDao {

    public void addUser(User user);

    public User getUser(int userId);

    public User findUser(String loginName, String password);

    public void update(User user);

    public void delete(User user);



}
