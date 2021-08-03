package org.example.StudyReflection;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class NewInstance {
    @Test
    public void test01() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //Object instance = clazz.newInstance();
        /**
         * newInstance()方法，创建对应运行时类的对象
         *
         * 调用的是空参的构造器
         * 要想要此方法正确运行，要求：
         * 1.运行时类必须提供空参的构造器
         * 2.空参的构造器的访问权限得够。通常设置为public
         *
         * 在Javabean中要求提供一个public的空参构造器
         * 1.便于通过反射，创建运行时类的对象
         * 2.便于子类继承此运行时类，默认调用super()，保证父类有此构造器
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    /**
     *创建一个指定类的对象
     * @param classPath  指定类的全限定名
     * @throws ClassNotFoundException
     */
    @Test
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        return  clazz.newInstance();
    }

    /**
     * 通过反射的方式来制造对象
     *   反射的动态性
     *  以前制造对象都是通过new的方式  那样只有实现确定了类名才能够构造对象
     *  通过反射可以让程序在运行的时候动态的创造对象  这就是反射最大的作用之一
     */
    @Test
    public void test03() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "org.example.StudyReflection.Person";
                break;
            case 3:
                //sql下的Date类没有空参构造器 会报错
                //classPath = "java.sql.Date";
                classPath = "java.lang.Object";
                break;
        }

        Object instance = getInstance(classPath);
        System.out.println(instance.toString());
    }


}
