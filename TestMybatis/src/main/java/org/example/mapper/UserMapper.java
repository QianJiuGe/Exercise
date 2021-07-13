package org.example.mapper;

import org.example.pojo.User;
import java.util.List;

public interface UserMapper {

    /**
     * 获取所有用户
     */
    public List<User> getAllUser();

    /**
     * 向数据库中插入数据
     */
    public int insertUser(User user);

}
