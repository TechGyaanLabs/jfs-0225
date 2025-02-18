package com.careerit.cj.loops.whileloop;

enum Day {
    SUNDAY, MONDAY, TUESDAY,
    WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

public class SwitchExample2 {

    public static void main(String[] args) {
        Day day = Day.THURSDAY;
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println("Number of letters in " + day + " is " + numLetters);
    }
}
