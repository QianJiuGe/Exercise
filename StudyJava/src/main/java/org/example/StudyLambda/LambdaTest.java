package org.example.StudyLambda;

import org.junit.jupiter.api.Test;

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
}
