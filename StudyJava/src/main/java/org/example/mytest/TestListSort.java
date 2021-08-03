package org.example.mytest;

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

    /**
     * * 形式参数：用于接收实际参数的变量（形式参数一般就在方法的声明上）
     *  * 实际参数：实际参与运算的变量
     *
     *  * 方法的参数如果是基本数据类型：形式参数的改变不影响实际参数。
     *  *
     *  * 基本数据类型：byte,short,int,float,double,char,boolean
     *
     *  * 方法的参数如果是引用数据类型：形式参数的改变直接影响实际参数
     *  *  引用数据类型：数组arr，接口，类
     *  *         string是个类，是引用数据类型
     */
    @Test
    public void test02(){
        int x =1,y=2;
        System.out.println("x:"+x+"  y:"+y);
        test03(x,y);
        System.out.println("x:"+x+"  y:"+y);

        /**
         * 为什么String没有因为形参的改变而改变  可能是因为常量池的原因
         *      具体原因还需进一步学习String类   java基础课
         */
        String buffer = "ht";
        System.out.println(buffer);
        test04(buffer);
        System.out.println(buffer);
    }
    private void test03(int x,int y){
        x = 520000;
        y = 0;
        return ;
    }
    private void test04(String buffer){
       buffer = "i love you";
        System.out.println(buffer);
       return;
    }

    /**
     * 传入的arr数组是引用数据类型  所以 形参的修改导致了实参也随着一起被修改
     */
    @Test
    public void test05() {
        int[] arr = {1,2,3,4,5};
        for(int x=0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
        System.out.println("----------");
        change(arr);
        System.out.println("~~~~~~~~~");
        for(int x=0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
    }

    public void change(int[] arr) {
        for(int x=0; x<arr.length; x++) {
            if(arr[x]%2==0) {
                arr[x]*=2;
            }
            System.out.println(arr[x]);
        }
    }
}
