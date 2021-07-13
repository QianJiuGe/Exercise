package org.example.service;

import org.example.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 获取所有用户
     */
    List<User> getAllUser();

    /**
     * 向数据库中插入数据
     */
    int insertUser(User user);

}
