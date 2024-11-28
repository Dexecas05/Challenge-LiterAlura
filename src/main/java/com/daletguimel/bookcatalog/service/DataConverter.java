package com.daletguimel.bookcatalog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {

    private final ObjectMapper objectMapper;

    public DataConverter() {
        this.objectMapper = new ObjectMapper();
    }


    @Override
    public <T> T fromJson(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Fallo al convertir el archivo Json a: " + type.getName() + e);
        }
    }
}
