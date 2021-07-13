package org.example.StudyStream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 学习Java8中Stream流的使用
 */
public class StudyStream {

    @Test
    public void test(){
        List<Integer> arr = new ArrayList<>();
        Stream.iterate(2,a-> {
            int i=1;
            while(i<a) {
                if(a%i==0){
                    i=1;
                    a++;
                }
                i++;
            }
            return i;
        }).limit(10).forEach(x->arr.add(x));

        //arr.forEach(System.out::println);

        System.out.println(arr);

    }

}
