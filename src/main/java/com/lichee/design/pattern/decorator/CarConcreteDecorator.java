package com.lichee.design.pattern.decorator;

/**
 * 具体装饰类 like BufferedInputStream
 */
public class CarConcreteDecorator extends Decorator {

    public CarConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void run() {
        super.run();
        this.carRun();
    }

    private void carRun() {
        System.out.println("run by car!");
    }
}
