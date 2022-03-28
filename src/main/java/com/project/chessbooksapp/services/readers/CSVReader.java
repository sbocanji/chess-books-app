package com.project.chessbooksapp.services.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CSVReader<T, C extends CSVColumns> extends Reader<T> {

    @Override
    List<T> readEntities(BufferedReader bufferedReader) {
        List<T> entityList = new ArrayList<>();
        try {
            String line;
            String headerLine = bufferedReader.readLine();
            String[] headers = headerLine.split(",");
            Map<C, Integer> headerMap = getHeaderColumns(headers);
            while ((line = bufferedReader.readLine()) != null) {
                if(line.equals("")) continue;
                String[] values = line.split(",");
                headerMap.forEach((key, value) -> {
                    if(key.isMandatory() && values[value].equals("")) throw new IllegalArgumentException("Invalid input.");
                });
                entityList.add(readEntity(headerMap, values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    public abstract T readEntity(Map<C, Integer> headers, String[] values);

    public abstract Map<C, Integer> getHeaderColumns(String[] headers);

}
