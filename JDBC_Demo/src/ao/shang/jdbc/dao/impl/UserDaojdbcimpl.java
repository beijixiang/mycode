package ao.shang.jdbc.dao.impl;

import ao.shang.jdbc.dao.DaoException;
import ao.shang.jdbc.dao.UserDao;
import ao.shang.jdbc.domain.User;
import ao.shang.jdbc.jdbcUtils;

import java.sql.*;

/**
 * Created by cai on 16-9-20.
 */
public class UserDaojdbcimpl implements UserDao {
    @Override
    public void addUser(User user) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "insert into user(name,money,birthday) values(?,?,?)";
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setDate(3, new Date(user.getBirthday().getTime()));
            ps.setFloat(2, user.getMoney());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }finally {
            jdbcUtils.free(rs,ps,conn);
        }
    }

    @Override
    public User getUser(int userId) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        User user = null;
        String sql = "SELECT id,name,money,birthday FROM user where id=?";
        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setMoney(rs.getFloat("money"));
            }
        }catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }finally {
            jdbcUtils.free(rs,ps,conn);
        }
        return user;
    }

    @Override
    public User findUser(String loginName, String password) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        User user = null;
        String sql = "SELECT id,name,money,birthday FROM user where name=?";
        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginName);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setMoney(rs.getFloat("money"));
            }
        }catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }finally {
            jdbcUtils.free(rs,ps,conn);
        }
        return user;
    }

    @Override
    public void update(User user) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "UPDATE user set name=?,money=?,birthday=? where id=?";

        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setFloat(2,user.getMoney());
            ps.setDate(3, new Date(user.getBirthday().getTime()));
            ps.setInt(4, user.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }finally {
            jdbcUtils.free(rs,ps,conn);
        }
    }

    @Override
    public void delete(User user) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "delete FROM user where id =?";
        try {
            conn = jdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }finally {
            jdbcUtils.free(rs,ps,conn);
        }
    }
}
