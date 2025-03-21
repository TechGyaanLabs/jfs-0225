package com.careerit.cj.interfaceexamples;

public class Bike extends  AbstractGame implements Game{

    @Override
    public void play() {
        System.out.println("You are playing game "+this.getClass().getSimpleName()+", please wear safety helmet");
    }

}
