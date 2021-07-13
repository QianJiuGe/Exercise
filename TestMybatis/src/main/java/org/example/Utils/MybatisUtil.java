package org.example.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {


    private static SqlSessionFactory sqlSessionFactory = null;
    //使用静态代码块读取mybatis配置文件
    static {
        String configPath = "Mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(configPath);
            //创建sqlSession对象
            SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取Sqlsession的方法
    public static SqlSession getSqlsession(){
        SqlSession sqlSession = null;
        if(sqlSessionFactory!=null){
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }
}
