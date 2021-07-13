package org.example.UserTest;

import org.example.mapper.UserDao;
import org.example.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestMybatis {
    private UserDao userDao;

    public void init() throws IOException {
        userDao = new UserDao("Mybatis.xml");
    }

    @Test
    public void getAllUser() throws IOException {
        init();
        List<User> users = userDao.getAllUser();
        for (User user:users ) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws IOException {
        init();
        User u =new User().builder()
                .id(2003L)
                .username("zfc")
                .age(28)
                .email("www.zfc.com").build();

        int res = userDao.insertUser(u);
        System.out.println(res);
    }
}
