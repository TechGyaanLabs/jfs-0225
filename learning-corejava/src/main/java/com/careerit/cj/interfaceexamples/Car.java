package com.careerit.cj.interfaceexamples;

public class Car extends AbstractGame implements Game{


    @Override
    public void play() {
        System.out.println("You are playing game "+this.getClass().getSimpleName()+", please wear seatbelt");
    }


}
