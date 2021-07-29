package org.example.StudyReflection;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Person {
    private String name;
    public Integer age;

    public void meet(){
        System.out.println("Hello,I'm a person!");
    }

    private void love(){
        System.out.println("I love you");
    }

    private Person(String name){
        this.name = name;
    }
}
