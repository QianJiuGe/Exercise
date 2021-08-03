package org.example.StudyReflection;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * getField获取的是public修饰的字段  包括子类和父类
 * getDeclareField获取的是当前运行时类下的字段  包括权限小的字段
 *
 * 一个Field对象包含了一个字段的所有信息：
 *
 * getName()：返回字段名称，例如，"name"；
 * getType()：返回字段类型，也是一个Class实例，例如，String.class；
 * getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
 */
public class TestReflection02 {
        @Test
        public void test () throws Exception {
            Class stdClass = Student.class;
            // 获取public字段"score":
            System.out.println(stdClass.getField("score"));
            // 获取继承的public字段"name":
            System.out.println(stdClass.getField("name"));
            // 获取private字段"grade":
            System.out.println(stdClass.getDeclaredField("grade"));

            System.out.println("************************************");

            Object p = new Person("Xiao Ming");
            Class c = p.getClass();
            Field f = c.getDeclaredField("name");
            /**
             * 如果是private定义的字段  需要设置访问权限才可以访问
             * 调用Field.setAccessible(true)的意思是，别管这个字段是不是public，一律允许访问
             */
           //f.setAccessible(true);
            Object value = f.get(p);
            System.out.println(value); // "Xiao Ming"
        }

    class Student extends Person {
        public int score;
        private int grade;

        public Student(String name) {
            super(name);
        }
    }

    class Person {
        public String name;
        public Person(String name){
            this.name =name;
        }

    }

}
