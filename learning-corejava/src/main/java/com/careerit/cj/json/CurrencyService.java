package com.careerit.cj.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class CurrencyService {



    public List<Currency> getCurrencies(){
        return loadCurrencies();
    }

    private List<Currency> loadCurrencies(){

        List<Currency> list = new ArrayList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(this.getClass().getResourceAsStream("/common-currency.json"));
            for(JsonNode node : jsonNode){
                String symbol = node.get("symbol").asText();
                String name = node.get("name").asText();
                String symbolNative = node.get("symbol_native").asText();
                int decimalDigits = node.get("decimal_digits").asInt();
                int rounding = node.get("rounding").asInt();
                String code = node.get("code").asText();
                String namePlural = node.get("name_plural").asText();
                Currency currency = new Currency(symbol, name, symbolNative, decimalDigits, rounding, code, namePlural);
                list.add(currency);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        CurrencyService service = new CurrencyService();
        List<Currency> currencies = service.getCurrencies();
        for(Currency currency: currencies){
            System.out.println(currency);
        }
    }

}
