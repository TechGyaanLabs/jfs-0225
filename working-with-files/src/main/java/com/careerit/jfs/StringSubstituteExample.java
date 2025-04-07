package com.careerit.jfs;

import org.apache.commons.text.StringSubstitutor;

import java.util.List;
import java.util.Map;

public class StringSubstituteExample {

    public static void main(String[] args) {


        String emailBody = "Dear ${name},\n" +
                "Your order with ID ${orderId} has been shipped.\n" +
                "Thank you for shopping with us!";



        List<Map<String, String>> valuesMap = List.of(
                Map.of("name", "John Doe", "orderId", "12345"),
                Map.of("name", "Krish T", "orderId", "67890"),
                Map.of("name", "Ravi K", "orderId", "54321")
        );

        for(Map<String, String> map : valuesMap) {
            StringSubstitutor substitute = new StringSubstitutor(map);
            String body = substitute.replace(emailBody);
            System.out.println(body);
            System.out.println("-".repeat(100));
        }

    }
}
