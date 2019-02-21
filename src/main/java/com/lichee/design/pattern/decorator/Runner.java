package com.lichee.design.pattern.decorator;

/**
 * 和java 的io流设计是一样的，这样可以保持扩展性的同时，
 * 大大减少多余子类的产生，实际上这是对java对象的一种装饰，
 * 而并非是类的装饰。
 */
public class Runner {

    public static void main(String[] args) {

        Component component = new CarConcreteDecorator(new BikeConcreteDecorator(new ConcreteComponent()));
        component.run();
    }
}
