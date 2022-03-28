package com.project.chessbooksapp.services.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.project.chessbooksapp.dto.BookEntityDto;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader<T> extends Reader<T> {

    private Class entityClass;

    public JsonReader(Class entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    List<T> readEntities(BufferedReader bufferedReader) {
        List<T> entityList = new ArrayList<>();
        ObjectMapper objectMapper = JsonMapper.builder().addHandler(new DeserializationProblemHandler() {
            @Override
            public Object handleWeirdStringValue(DeserializationContext ctxt, Class<?> targetType, String valueToConvert, String failureMsg) throws IOException {
                if (valueToConvert.equals("y")) return true;
                return false;
            }
        }).build();
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) sb.append(line);
            JsonNode jsonNode = objectMapper.readTree(sb.toString());
            for (JsonNode entityObject : jsonNode) {
                T entity = (T) objectMapper.readValue(String.valueOf((T) entityObject), entityClass);
                entityList.add(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }
}
