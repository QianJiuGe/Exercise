package org.example.StudyFinalANDStatic;

import org.junit.jupiter.api.Test;

public class TestFinalAndStatic {

    @Test
    public void test(){
        StudyFinalANDStatic object1 = new StudyFinalANDStatic("ht","001");

        //调用final
        System.out.println(object1.id);
        //调用static
        System.out.println(StudyFinalANDStatic.author);
        StudyFinalANDStatic object2 = new StudyFinalANDStatic("zfc","002");
        System.out.println(StudyFinalANDStatic.getAuthor());

        StudyFinalANDStatic.author = "zzy";
        System.out.println(StudyFinalANDStatic.author);
        StudyFinalANDStatic.author = "zbc";


        //调用final static
        System.out.println(StudyFinalANDStatic.age);
    }


}
