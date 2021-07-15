package org.example.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Computer {

    private Integer id;
    private String brand;
    private BigDecimal price;
    private String cpu;
    private String gpu;

}
