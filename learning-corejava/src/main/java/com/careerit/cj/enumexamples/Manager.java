package com.careerit.cj.enumexamples;

public class Manager {

    public static void main(String[] args) {

            TShirtSize[] arr = TShirtSize.values();

            for(TShirtSize size:arr) {
                System.out.println(size);
            }
            TShirtSize obj = TShirtSize.valueOf("LARGE");
            System.out.println(obj);
            System.out.println(obj.getSize());

            TShirtSize obj2 = TShirtSize.valueOfSize(42);
            System.out.println(obj2);
    }
}
