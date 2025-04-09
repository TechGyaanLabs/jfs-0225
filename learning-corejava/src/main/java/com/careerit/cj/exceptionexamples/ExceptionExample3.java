package com.careerit.cj.exceptionexamples;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.util.Scanner;

@Data
class Result{
    double num1;
    double num2;
    double result;
}
public class ExceptionExample3 {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the num1 :");
            double num1 = sc.nextDouble();
            System.out.println("Enter the num2 :");
            double num2 = sc.nextDouble();
            double res = num1 / num2;

            Result result = new Result();
            result.setNum1(num1);
            result.setNum2(num2);
            result.setResult(res);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(result);
            System.out.println(jsonString);
        }catch (ArithmeticException e){
            System.out.println("You are trying to divide by zero");
            e.printStackTrace();
        }catch (IOException e) {
            System.out.println("Error while reading/writing json");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
