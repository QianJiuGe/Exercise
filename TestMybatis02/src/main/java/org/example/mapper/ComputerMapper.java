package org.example.mapper;

import org.example.pojo.Computer;

import java.util.List;
import java.util.Map;

public interface ComputerMapper {
    /**
     * 获取所有电脑信息
     */
    List<Computer> getAllComputer();

    /**
     *获取电脑和拥有者的信息
     */
    List<Map<String,Object>> getComputerAndName();

    /**
     *测试foreach标签
     * @param list
     */
    List<Computer> testFor(List<Integer> list);
}
