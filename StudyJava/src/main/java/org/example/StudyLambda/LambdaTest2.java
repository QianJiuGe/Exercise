package org.example.StudyLambda;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.nio.channels.NonWritableChannelException;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Lambda表达式的使用
 **/
public class LambdaTest2 {


    /**
     * 传参  没有返回值
     */
    @Test
    public void test(){

        Consumer<String> con =new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("********************************");

        Consumer<String > con1 = (String s) -> System.out.println(s);
        con1.accept("一个是听的人当真了，一个是说的人当真了。");

    }

    /**
     *需要多个执行参数，多条执行语句，并且有返回值的时候
     */
    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(1,5));
        System.out.println("**********");
        Comparator<Integer> com2 = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12,23));
    }

    @Test
    public void test3(){

        JSONArray jsonArray = JSONArray.parseArray("[{\"1\": {\"name\":\"maple\",\"sex\":\"man\",\"childrens\":[{\"name\":\"草根\",\"sex\":\"man\",\"date\":\"2018-01-01\"},{\"name\":\"merry\",\"sex\":\"woman\",\"date\":\"2017-01-01\"},{\"name\":\"liming\",\"sex\":\"woman\",\"date\":\"2016-01-01\"}]}}]");
        jsonArray = jsonArray.stream().map(obj -> {
            JSONObject returnObj = new JSONObject();
            JSONObject jsonObj = (JSONObject)obj;
            jsonObj.forEach((key,val) -> {
                returnObj.put(key,((JSONObject)val).getJSONArray("childrens"));
            });
            return returnObj;
        }).collect(Collectors.toCollection(JSONArray::new));

        System.out.println(jsonArray);

    }

}
