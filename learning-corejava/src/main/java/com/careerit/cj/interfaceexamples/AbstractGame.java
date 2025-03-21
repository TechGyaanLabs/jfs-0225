package com.careerit.cj.interfaceexamples;

public abstract class AbstractGame implements Game{

    @Override
    public void start() {
        System.out.println("Game "+this.getClass().getSimpleName()+" is started");
    }

    @Override
    public void stop() {
        System.out.println("Game "+this.getClass().getSimpleName()+" is stopped");
    }
}
