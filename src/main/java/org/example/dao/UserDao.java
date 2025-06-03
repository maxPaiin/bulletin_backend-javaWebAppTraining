package org.example.dao;

import org.example.pojo.User;

public interface UserDao {

    User findByUserloginId(String loginId);

    User findByUserId(Integer userId);
}
