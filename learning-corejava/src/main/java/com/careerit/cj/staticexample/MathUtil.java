package com.careerit.cj.staticexample;

public final class MathUtil {

        private MathUtil(){}

        public static double emiCalculator(double amount, double rate, int months){
            // Complete code
            return 0;
        }

        public static double sumFirstNPrimeNumbers(int n){
            // Complete code
            return 0;
        }

        public static boolean isArmstrongNumber(int num){
            // Complete code
            return false;
        }

        public static int max(int... numbers){
            // Complete code
            return 0;
        }
        public static int[] getUniqueRandomNumbers(int lb,int ub, int n){
            // Complete code
             return null;
        }

        // 100, 20, 80  =>
        // 100, 20  200 => 80

        public static void getCreditAmount(double amount, double tax, double creditBalance){
            // if amount + tax > credcitBalance distribute equally for amount and tax
            // else show remaining creditBalance.
            double totalAmount = amount + tax;
            if(totalAmount > creditBalance){
                // credit balance should distribute equally
            }else{
                System.out.println("Remaining amount is " + (creditBalance - totalAmount));
            }

        }
}
