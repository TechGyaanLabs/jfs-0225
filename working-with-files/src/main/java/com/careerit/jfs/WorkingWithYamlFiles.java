package com.careerit.jfs;

import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;





public class WorkingWithYamlFiles {

    public static void main(String[] args) {

        try {
            LoaderOptions loaderOptions = new LoaderOptions();
            Yaml yaml = new Yaml(new Constructor(AppWrapper.class, loaderOptions));
            AppWrapper configData = yaml.load(WorkingWithYamlFiles.class.getClassLoader().getResourceAsStream("config.yaml"));

            ConfigData app = configData.getApp();
            System.out.println("Name : " + app.getName());
            System.out.println("Locations : " + app.getLocations());
            System.out.println("Welcome : " + app.getWelcome());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
