package org.example.mapper;

import org.example.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 获取所有用户
     */
    List<User> getAllUser();

}
