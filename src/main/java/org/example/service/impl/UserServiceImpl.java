package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.pojo.User;
import org.example.service.UserService;

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
}
