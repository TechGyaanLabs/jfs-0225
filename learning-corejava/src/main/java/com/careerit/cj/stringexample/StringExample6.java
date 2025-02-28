package com.careerit.cj.stringexample;

public class StringExample6 {

    public static void main(String[] args) {


        String data = "Rajesh, Manish, Suman, Rohit, Mani Deep  , Jayesh G";

        String[] names = data.split(",");
        String[] properNames = new String[names.length];
        int i = 0;
        for(String name:names){
            name = name.trim().toUpperCase();
            properNames[i++] = name;
        }
        // Print names, which contains "I" init.
        for(String name:properNames){
            if(name.contains("I")){
                System.out.println(name);
            }
        }

        String emailData = "raj@gmail.com,manish@gmail.com,suman@gmail.com,raj@gamil,rohit@gmail.com,mani@deep,jayesh@gmail.com,johngmail.com";

        // Get invalid email ids

        // @ .
        String[] emailArr = emailData.split(",");

        for(String email:emailArr){
            if(!email.contains("@") || !email.contains(".")){
                System.out.println(email);
            }
        }

        String ifsc = "ICICI530545466";

        System.out.println(ifsc.substring(0, 5));
        System.out.println(ifsc.substring(ifsc.length() - 4));

        String str = "Hello Rajesh  ";
        System.out.println(str.trim().substring(5));
        System.out.println(str.trim().substring(5).trim().toUpperCase().substring(2));
    }
}
