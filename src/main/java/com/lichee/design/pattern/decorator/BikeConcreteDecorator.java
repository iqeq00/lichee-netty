package com.lichee.design.pattern.decorator;

/**
 * 具体装饰类 like BufferedInputStream
 */
public class BikeConcreteDecorator extends Decorator {

    public BikeConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void run() {
        super.run();
        this.bikeRun();
    }

    private void bikeRun() {
        System.out.println("run by bike!");
    }
}
