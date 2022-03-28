package com.project.chessbooksapp.services.importService.parsers;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonParser<T> implements Parser<T> {

    private Class entityClass;

    public JsonParser(Class entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> readEntities(InputStream inputStream) {
        List<T> entityList = new ArrayList<>();
        ObjectMapper objectMapper = JsonMapper.builder().addHandler(new DeserializationProblemHandler() {
            @Override
            public Object handleWeirdStringValue(DeserializationContext ctxt, Class<?> targetType, String valueToConvert, String failureMsg) throws IOException {
                if (valueToConvert.equals("y")) return true;
                return false;
            }
        }).build();
        try {
            String fileContent = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JsonNode jsonNode = objectMapper.readTree(fileContent);
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
