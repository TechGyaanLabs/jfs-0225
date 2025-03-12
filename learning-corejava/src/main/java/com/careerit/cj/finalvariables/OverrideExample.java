package com.careerit.cj.finalvariables;

class Greetings{
     public void greetings(){
        System.out.println("Have a nice day");
    }
}
class BirthdayGreetings extends Greetings{

    @Override
    public void greetings(){
        System.out.println( "Happy Birthday");
    }
}
class AnniversaryGreetings extends Greetings{

    @Override
    public void greetings(){
        System.out.println( "Happy Anniversary");
    }
}
public class OverrideExample {

    public static void main(String[] args) {

        Greetings g = new BirthdayGreetings();
        g.greetings();
    }
}
