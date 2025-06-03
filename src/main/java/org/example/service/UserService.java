package org.example.service;

import org.example.pojo.User;

public interface UserService {
    User findByUserloginId(String loginId);

    User findByUserId(Integer userId);
}
