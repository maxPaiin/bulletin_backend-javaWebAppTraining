package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.util.MD5Util;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User findByUserloginId(String loginId) {
        return userDao.findByUserloginId(loginId);
    }

    @Override
    public User findByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public int registUser(User registUser) {
        var encypt = MD5Util.encrypt(registUser.getPassword()); //Password encrypted with MD5
        registUser.setPassword(encypt); // Reset user password with encrypted password into database
        return userDao.registUser(registUser);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }
}
