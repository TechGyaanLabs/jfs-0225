package com.careerit.cj.arrays;

public class ArrayExample2 {

    public static void main(String[] args) {

        String[] names = new String[]{"Krishna", "Raj", "Ramesh", "Ravi", "John", "Saleem", "Rajesh", "Mani", "Naresh", "Jayesh", "Anish"};
        String name = "Saleem";
        int index = indexOf(names, name);
        if(index != -1){
            System.out.println("Name "+name+" is found in the array at index "+index);
        }else{
            System.out.println("Name "+name+" is not found in the array");
        }
    }

    public static int indexOf(String[] names, String name){
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
