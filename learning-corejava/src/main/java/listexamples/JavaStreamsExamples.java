package listexamples;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamsExamples {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
        System.out.println("List of numbers: " + list);

        // Get the numbers which are divisible by 3 but not with 6 into another list

      /*  List<Integer> divBy3Not6 = new ArrayList<>();
        for(Integer ele: list){
            if(ele % 3 == 0 && ele % 6 != 0){
                divBy3Not6.add(ele);
            }
        }*/

        List<Integer> divBy3Not6 = list
                .stream()
                .filter(ele -> ele % 3 == 0 && ele % 6 != 0)
                .toList();
        System.out.println("Numbers which are divisible by 3 but not with 6: "+divBy3Not6);

        // Get all even numbers into another list

//        List<Integer> evenNumbers = new ArrayList<>();
//        for(Integer ele: list){
//            if(ele % 2 == 0){
//                evenNumbers.add(ele);
//            }
//        }
        List<Integer> evenNumbers = list
                .stream()
                .filter(ele -> ele % 2 == 0)
                .toList();
        System.out.println("Even numbers: "+evenNumbers);

        // Get all odd numbers increment by 1 put it into another list

       /* List<Integer> oddNumbers = new ArrayList<>();
        for(Integer ele: list){
            if(ele % 2 != 0){
                oddNumbers.add(ele+1);
            }
        }*/

        List<Integer> oddNumbersIncrBy1 = list
                .stream()
                .filter(ele -> ele % 2 != 0)
                .map(ele -> ele + 1)
                .toList();
        System.out.println("Odd numbers incremented by 1: "+oddNumbersIncrBy1);

    }
}
