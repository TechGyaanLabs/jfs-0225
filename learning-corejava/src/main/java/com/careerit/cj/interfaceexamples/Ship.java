package com.careerit.cj.interfaceexamples;

public class Ship extends AbstractGame implements Game{


    @Override
    public void play() {
        System.out.println("You are playing game "+this.getClass().getSimpleName()+", please wear life jacket");
    }


}
