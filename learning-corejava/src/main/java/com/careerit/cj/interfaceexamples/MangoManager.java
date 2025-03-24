package com.careerit.cj.interfaceexamples;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Mango{
    int size;
    String color;

    public Mango(int size, String color) {

        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

public class MangoManager {

    public static void main(String[] args) {

        List<Mango> mongos = getMangoList();
        Predicate<Mango> redMongoPredicate = mango -> mango.getColor().equals("red");

        List<Mango> redMangoes = filterMangoes(mongos, redMongoPredicate);
        System.out.println("Total red mangoes : "+redMangoes.size());
        Predicate<Mango> weightPredicate = mango -> mango.getSize() > 2;
        List<Mango> weightMangoes = filterMangoes(mongos, weightPredicate);
        System.out.println("Mangoes with weight > 2: "+weightMangoes.size());
    }

    public static List<Mango> filterMangoes(List<Mango> mongos, Predicate<Mango> predicate) {
        List<Mango> list = new ArrayList<>();
        for(Mango m: mongos) {
            if(predicate.test(m)) {
                list.add(m);
            }
        }
        return list;
    }


    private static List<Mango> getMangoList() {
        List<Mango> list = new ArrayList<>();
        list.add(new Mango(1, "red"));
        list.add(new Mango(3, "green"));
        list.add(new Mango(2, "yellow"));
        list.add(new Mango(2, "red"));
        list.add(new Mango(2, "green"));
        list.add(new Mango(3, "yellow"));
        return list;
    }
}
