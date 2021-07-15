package org.example.service;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 获取所有用户
     */
    List<User> getAllUser();

    /**
     * 向数据库中插入数据
     */
    int insertUser(User user);

    /**
     * 测试返回类型为map
     */
    Map<String,Object> selectOneUser();

    /**
     * 测试返回类型为List<Map>
     */
    List<Map<String,Object>> selectAllUser();
}
