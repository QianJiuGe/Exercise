package org.example;

import com.yogurt.dao.UserDao;
import org.example.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestMapper {
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        userDao = new UserDao("mybatis.xml");
    }

//    @Test
//    public void insertTest() {
//        Student student = new Student();
//        student.setName("yogurt");
//        student.setAge(24);
//        student.setGender(1);
//        student.setScore(100);
//        studentDao.addStudent(student);
//    }

    @Test
    public void findAllTest() {
        List<User> all = UserDao.findAll();
        all.forEach(System.out::println);
    }

}
