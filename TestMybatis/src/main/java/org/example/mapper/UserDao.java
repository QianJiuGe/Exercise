package org.example.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDao(String configPath) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(configPath);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 获取所有的用户
     * @return
     */
    public List<User> getAllUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> allUser = sqlSession.selectList("getAllUser");
        sqlSession.close();
        return allUser;
    }

    /**
     * 插入用户
     */
    public int insertUser(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int res = sqlSession.insert("insertUser",user);
        System.out.println("执行插入语句，插入数据为:"+user);
        //mybatis默认不是自动提交事务的，所以在执行插入、修改和删除的操作的时候需要手动提交
        sqlSession.commit();
        sqlSession.close();
        return res;
    }

}