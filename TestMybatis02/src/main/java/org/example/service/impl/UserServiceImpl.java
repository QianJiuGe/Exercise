package org.example.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.Utils.MybatisUtil;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUser() {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.getAllUser();

        sqlSession.close();
        return users;
    }

    @Override
    public List<Map<String, Object>> selectAllUser() {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Map<String,Object>> mapList = userMapper.selectAllUser();

        sqlSession.close();
        return mapList;
    }

    @Override
    public Map<String, Object> selectOneUser() {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = userMapper.selectOneUser();

        sqlSession.close();
        return map;
    }

    @Override
    public int insertUser(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.insertUser(user);

        sqlSession.commit();
        sqlSession.close();
        return res;
    }
}
