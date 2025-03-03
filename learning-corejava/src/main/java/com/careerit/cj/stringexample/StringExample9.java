package com.careerit.cj.stringexample;

public class StringExample9 {


    public static void main(String[] args) {

        String data ="Rajesh,2000,10-Mar-2025:Sai A,2000,20-Mar-2025:Mani Deep,2000,15-Mar-2025:Joh Doe,3000,10-Mar-2025";

        String[] dataArray = data.split(":");

        StringBuilder sb = new StringBuilder();
        for(String dataItem:dataArray){
            String[] arr = dataItem.split(",");
            String name = arr[0];
            String dueAmount = arr[1];
            String date = arr[2];
            sb.append("Hi ").append(name).append(",").append("\n\n\t your due amount is ").append(dueAmount).append(" and due date is ").append(date).append("\n\n");
        }

        System.out.println(sb.toString());

    }
}
