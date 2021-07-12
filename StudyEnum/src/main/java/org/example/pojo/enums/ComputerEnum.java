package org.example.pojo.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public enum ComputerEnum {

    HASEE("i7-11800H","RTX3060",5999),
    ACER("i7-11800H","RTX3060",6299),
    ROG("R7-5900HX","RTX3070",12999),
    LENOVO("R7-5800H","RTX3050Ti",7999);

    ComputerEnum(String cpu, String gpu, Integer price) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.price = price;
        System.out.println(this.name());
    }

    private String cpu;
    private String gpu;
    private Integer price;
}
