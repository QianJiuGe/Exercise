package org.example;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.alibaba.fastjson.JSONArray.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 测试MybatisUtil
     */
    @Test
    public void Test01()
    {
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAllUser();
        users.forEach(System.out::println);
    }

    /**
     * 测试返回类型为 Map的
     */
    @Test
    public void Test02(){
        UserService userService = new UserServiceImpl();
        Map<String,Object> map = userService.selectOneUser();

        map.forEach((k,v)-> System.out.println(k+":"+v));
    }

    /**
     * 测试返回类型为 List<Map></Map>的
     */
    @Test
    public void Test03(){
        UserService userService = new UserServiceImpl();
        List<Map<String,Object>> mapList = userService.selectAllUser();


        //mapList.forEach();

        List<Map<String, Object>> maps = mapList.stream().filter(distinctByKey(b -> b.get("username"))).collect(Collectors.toList());

        maps.forEach(map->{
            System.out.println(map.get("id")+":"+map);
        });

        //System.out.println(jsonObjects);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
