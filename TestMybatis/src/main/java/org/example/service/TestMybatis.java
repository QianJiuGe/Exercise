package org.example.service;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.example.mapper.UserDao;
import org.example.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestMybatis {
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        userDao = new UserDao("Mybatis.xml");
    }

    @Test
    public void getAllUser(){
        List<User> users = userDao.getAllUser();
        for (User user:users ) {
            System.out.println(user);
        }
    }
}
