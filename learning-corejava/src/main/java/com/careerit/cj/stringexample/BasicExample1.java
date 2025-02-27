package com.careerit.cj.stringexample;


import java.util.Arrays;

class Greetings{
    String message;
    Greetings(String message){
        this.message = message;
    }
    void greet(){
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "Greetings{" +
                "message='" + message + '\'' +
                '}';
    }
}
public class BasicExample1 {

    public static void main(String[] args) {
        String name1 = "Krishna";
        String name2 = new String("Krishna");
        char[] chArr = new char[]{'K', 'r', 'i', 's', 'h', 'n', 'a'};
        String name3 = new String(chArr);

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);


        int[] arr = new int[]{2,4,6,8,10,12};
        System.out.println(Arrays.toString(arr));

        Greetings gs = new Greetings("Hello Krishna");
        System.out.println(gs);

    }
}
