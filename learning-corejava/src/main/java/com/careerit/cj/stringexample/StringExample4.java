package com.careerit.cj.stringexample;

public class StringExample4 {

    public static void main(String[] args) {

        boolean result = validateUser(" admin ", "admin@123 ");
        System.out.println(result);

        String name = "malayalam";
        System.out.println(name.length());
        System.out.println(args.length);

        System.out.println(name.charAt(0));

        for(int i=0;i<name.length();i++){
            System.out.println(name.charAt(i));
        }

        for(int i=name.length()-1;i>=0;i--){
            System.out.println(name.charAt(i));
        }

        char[] ch = name.toCharArray();
        for(char c:ch){
            System.out.println(c);
        }

    }

    public static boolean validateUser(String username, String password){
        String user = "admin";
        String pass = "admin@123";
        return user.equals(username.trim()) && pass.equals(password.trim());
    }
}
