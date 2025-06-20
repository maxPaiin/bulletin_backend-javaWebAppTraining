package org.example.dao.impl;

import org.example.dao.BaseDao;
import org.example.dao.UserDao;
import org.example.pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User findByUserloginId(String loginId) {
        String sql = """
                SELECT * FROM user \s
                WHERE login_id = ? AND delete_flg = '0'
                """;
        List<User> userList = baseQuery(User.class,sql,loginId);
        return userList != null ? userList.getFirst() : null;
    }

    @Override
    public User findByUserId(Integer userId) {
        String sql = """
                SELECT * FROM user \s
                WHERE user_id = ? AND delete_flg = '0'
                """;
        List<User> userList = baseQuery(User.class,sql,userId);
        return userList !=null ? userList.getFirst() : null;
    }

    @Override
    public int registUser(User registUser) {
        String sql = """
                insert into User 
                values(DEFAULT,?,?,?,'0',DEFAULT,DEFAULT)
                """;
        return baseUpdate(sql,registUser.getLogin_id(),registUser.getPassword(),registUser.getName());
    }

    @Override
    public int deleteUser(User user) {
        String sql = """
                update User set delete_flg = '1' where user_id = ?
                """;
        return baseUpdate(sql,user.getUser_id());
    }
}
