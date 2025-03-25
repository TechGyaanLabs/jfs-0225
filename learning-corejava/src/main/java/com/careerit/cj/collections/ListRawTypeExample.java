package com.careerit.cj.collections;

import java.util.ArrayList;
import java.util.List;

class Car{
    public void start(){
        System.out.println("Car started");
    }
}
class Employee{
    public void showProject(){
        System.out.println("Project details");
    }
}
class Bike {
    public void play() {
        System.out.println("You are playing game "+this.getClass().getSimpleName()+", please wear safety helmet");
    }
}
public class ListRawTypeExample {

    public static void main(String[] args) {

            Car car1 = new Car();
            Car car2 = new Car();
            List<Car> list = new ArrayList<>();
            list.add(car1);
            list.add(car2);

            for(Car ref:list){
                ref.start();
            }


    }
}
