package org.example.StudyLambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @Author HuangTao
 * @Description //TODO 测试Lambda表达式
 * @Date 17:09 2021/7/12
 * @Param 
 * @return 
 **/
public class LambdaTest {
    @Test
    public void test1(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我在测试Lambda表达式！");
            }
        };
        r1.run();
        System.out.println("***********************************");

        Runnable r2 =() -> System.out.println("这个就是Lambda表达式,真牛逼！");
        r2.run();
    }

    @Test
    public void Test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        Integer x = 12;
        int compare1 = com1.compare(12,13);
        System.out.println(compare1);
        System.out.println("****************************************");

        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com2.compare(13,12);
        System.out.println(compare2);

    }


}
