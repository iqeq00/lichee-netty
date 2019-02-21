package com.lichee.design.pattern.decorator;

/**
 * 具体构件 like FileInputStream
 */
public class ConcreteComponent implements Component {

    @Override
    public void run() {
        System.out.println("people run!");
    }
}
