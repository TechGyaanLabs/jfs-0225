package com.careerit.cj.abstractcls;

import java.util.ArrayList;
import java.util.List;

abstract class Game{
    public  void start(){
        System.out.println("Game "+this.getClass().getSimpleName()+" is started");
    }
    public abstract void play();
    public  void stop(){
        System.out.println("Game "+this.getClass().getSimpleName()+ " is stopped");
    }
}
class Bike extends  Game{

        @Override
        public void play(){
            System.out.println("You are playing "+this.getClass().getSimpleName()+", please wear safety helmet");
        }
}
class Car extends  Game{

        @Override
        public void play(){
            System.out.println("You are playing "+this.getClass().getSimpleName()+", please wear seatbelt");
        }

}
class Ship extends  Game{

        @Override
        public void play(){
            System.out.println("You are playing "+this.getClass().getSimpleName()+", please wear life jacket");
        }

}
public class GameManager {

    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        games.add(new Bike());
        games.add(new Car());
        games.add(new Ship());

        for(Game g:games){
            g.start();
            g.play();
            g.stop();
            System.out.println("--------------------------------");
        }

    }
}
