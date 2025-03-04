package com.careerit.cj.enumexamples;

public class PlanetManager {

    public static void main(String[] args) {

            Planet[] arr = Planet.values();
            double weight = 80;
            for(Planet planet:arr) {
                double mass = weight/Planet.EARTH.surfaceGravity();
                System.out.println("Weight on earth "+weight+" - "+planet.name() +" "+planet.surfaceWeight(mass));
            }
    }
}
