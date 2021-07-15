package org.example.StudyFinalANDStatic;

public class StudyFinalANDStatic {
    //所有的类对象都会共用这个变量  无需建立对象就可以调用
    public static String author ;

    //被赋值了就不能够被修改了（被赋值之后就是常量了）  必须创建对象才可以被调用
    public final String id;

    //被其修饰的变量可以视作常量了  直接通过类调用
    public final static String age = "18";

    public StudyFinalANDStatic(String author,String id) {
        this.id = id;
        this.author = author;
    }

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        StudyFinalANDStatic.author = author;
    }

    public String getId() {
        return id;
    }

    public static String getAge() {
        return age;
    }


}
