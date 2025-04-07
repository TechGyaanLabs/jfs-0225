package com.careerit.jfs;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UsageOfPropertiesFile {


    public void replacePropertiesVariables(){
        Properties properties = new Properties();
        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            Map<String, String> valuesMap = new HashMap<>();
            for (String key : properties.stringPropertyNames()) {
                valuesMap.put(key, properties.getProperty(key));
            }
            StringSubstitutor substitutor = new StringSubstitutor(valuesMap);

            for (String key : properties.stringPropertyNames()) {
                System.out.println("Key: " + key + ", Value: " + substitutor.replace(properties.getProperty(key)));
            }

        }catch (Exception e){
           e.printStackTrace();
        }
    }

    public void loadPropertiesFile() {
        Properties properties = new Properties();
        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
            String name = properties.getProperty("user.name");
            String email = properties.getProperty("user.email");
            String city = properties.getProperty("user.city");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("City: " + city);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("name", "John Doe");
        properties.put("age", "30");
        properties.put("city", "New York");

        System.out.println("Name: " + properties.getProperty("name"));
        System.out.println("Age: " + properties.getProperty("age"));
        System.out.println("City: " + properties.getProperty("city"));

        UsageOfPropertiesFile usageOfPropertiesFile = new UsageOfPropertiesFile();
        usageOfPropertiesFile.loadPropertiesFile();

        usageOfPropertiesFile.replacePropertiesVariables();

    }


}
