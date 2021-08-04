package org.example;

import org.example.pojo.enums.ComputerEnum;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ComputerEnum rog = ComputerEnum.ROG;
        ComputerEnum computerEnum = ComputerEnum.LENOVO;
        System.out.println( rog.name() +":"+rog.getCpu() );
        System.out.println(computerEnum.getGpu());
    }
}
