package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonFileService implements FileService {
    @Override
    public File getFile(List<Contact> contacts) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule()); // Register Java 8 date/time module
        
        try {
            // Create a file in the system's temporary directory with a proper name
            Path tempDir = Files.createTempDirectory("cbook");
            String fileName = "contacts_" + System.currentTimeMillis() + ".json";
            File file = new File(tempDir.toFile(), fileName);
            objectMapper.writeValue(file, contacts);
            
            // Register the file for deletion when the JVM exits
            file.deleteOnExit();
            tempDir.toFile().deleteOnExit();
            
            return file;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create JSON file: " + e.getMessage(), e);
        }
    }
}
