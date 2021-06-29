package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestListSort {

    @Test
    public void listSort(){

        List<String> list = new ArrayList<>();
        list.add("52ss");
        list.add("zzz.hk.cn");
        list.add("www.baidu.com");
        list.add("www.google.com");
        list.add("gf.cn");

        for (String str:list) {
            System.out.println(str);
        }

        System.out.println("*****************************after**********************************");

        list.sort(String::compareTo);

        for (String str:list) {
            System.out.println(str);
        }
    }
}
