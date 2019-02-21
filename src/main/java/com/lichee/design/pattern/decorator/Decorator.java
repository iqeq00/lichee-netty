package com.lichee.design.pattern.decorator;

/**
 * 抽象装饰类 like FilterInputStream
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void run() {
        component.run();
    }
}
