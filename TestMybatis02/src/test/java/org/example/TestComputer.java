package org.example;

import org.example.pojo.Computer;
import org.example.service.ComputerService;
import org.example.service.impl.ComputerServiceImpl;
import org.junit.Test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestComputer {

    @Test
    public void test(){
        ComputerService computerService = new ComputerServiceImpl();
        List<Computer> allComputer = computerService.getAllComputer();

        List<Computer> computers = allComputer.stream().filter(computer -> {
           return computer.getUserId()!=null;
        }).collect(Collectors.toList());

        computers.forEach(System.out::println);

    }

    @Test
    public void test02(){
        ComputerService computerService = new ComputerServiceImpl();
        List<Map<String,Object>> mapList = computerService.getComputerAndName();

        mapList.forEach(map->{
            if(map.get("username")==null)
                map.put("username", "do not have owner");
        });

        mapList.forEach(System.out::println);

    }

    @Test
    public void testFor(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);

        ComputerService computerService = new ComputerServiceImpl();
        List<Computer> computers = computerService.testFor(list);

        computers.forEach(System.out::println);

    }

}
