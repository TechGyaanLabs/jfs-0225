package com.careerit.cj.loops.whileloop;

public class NumberOdDayInMonth {

    public static void main(String[] args) {
        System.out.println(numberOfDays(2,2024));
        System.out.println(numberOfDays(2,2025));
    }

    public static int numberOfDays(int month, int year){
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 ->  31;
            case 4, 6, 9, 11 ->  30;
            case 2 ->{
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    yield 29;
                }else{
                    yield 28;
                }
            }
            default -> throw new IllegalArgumentException("Invalid month name");
        };
    }


}
