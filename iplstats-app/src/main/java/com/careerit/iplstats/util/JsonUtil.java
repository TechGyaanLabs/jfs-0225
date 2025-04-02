package com.careerit.iplstats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtil {


    public static <T> List<T> loadData(String fileName, TypeReference<List<T>> typeReference){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(JsonUtil.class.getResourceAsStream(fileName), typeReference);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
