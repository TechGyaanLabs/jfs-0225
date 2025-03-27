package com.careerit.cj.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class CountryService {

    public List<Country> getCountries(){
        return loadCountries();
    }

    private List<Country> loadCountries() {
        List<Country> list = new ArrayList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(this.getClass().getResourceAsStream("/countries.json"));
            for(JsonNode node : jsonNode){
                String commonName = node.get("name").get("common").asText();
                String officialName = node.get("name").get("official").asText();
                List<String> capitals = new ArrayList<>();
                JsonNode capitalsNode = node.get("capital");
                if(capitalsNode!=null) {
                    for (JsonNode capitalNode : capitalsNode) {
                        capitals.add(capitalNode.asText());
                    }
                }
                String region = node.get("region").asText();
                double population = node.get("population").asDouble();
                double area = node.get("area").asDouble();
                String flagSvgUrl = node.get("flags").get("svg").asText();
                Country country = new Country(commonName, officialName, capitals, region, population, area, flagSvgUrl);
                list.add(country);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        CountryService service = new CountryService();
        List<Country> countries = service.getCountries();
        for(Country country: countries){
            System.out.println(country);
            System.out.println("-------------------------------------------------");
        }
    }
}
