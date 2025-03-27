package com.careerit.cj.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductManager {

    public static void main(String[] args) {

        String productJson = "{\"name\":\"Laptop\",\"price\":45000.0,\"category\":\"Electronics\",\"description\":\"Dell Laptop\"}";
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        try {
            product = mapper.readValue(productJson, Product.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(product);
    }
}
