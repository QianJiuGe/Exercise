package org.example.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.Utils.MybatisUtil;
import org.example.mapper.ComputerMapper;
import org.example.pojo.Computer;
import org.example.service.ComputerService;

import java.util.List;
import java.util.Map;

public class ComputerServiceImpl implements ComputerService {

    @Override
    public List<Computer> getAllComputer() {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        ComputerMapper mapper = sqlSession.getMapper(ComputerMapper.class);

        List<Computer> allComputer = mapper.getAllComputer();

        return allComputer;
    }

    @Override
    public List<Map<String, Object>> getComputerAndName() {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        ComputerMapper mapper = sqlSession.getMapper(ComputerMapper.class);

        List<Map<String,Object>> allComputer = mapper.getComputerAndName();

        return allComputer;
    }

    @Override
    public List<Computer> testFor(List<Integer> list) {
        SqlSession sqlSession = MybatisUtil.getSqlsession();
        ComputerMapper mapper = sqlSession.getMapper(ComputerMapper.class);

        List<Computer> allComputer = mapper.testFor(list);

        return allComputer;
    }
}
